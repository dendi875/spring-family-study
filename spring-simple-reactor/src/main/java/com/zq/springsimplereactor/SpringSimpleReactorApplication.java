package com.zq.springsimplereactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@SpringBootApplication
public class SpringSimpleReactorApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSimpleReactorApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
	}


	/**
	 * 演示发布订阅在主线程上
	 */
	private void demo1() throws InterruptedException {
		Flux.range(1, 6)
				.doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
				.doOnComplete(() -> log.info("Publisher COMPLETE 1"))
				.map(i -> {
					log.info("Publish {}, {}", Thread.currentThread(), i);
					return i;
				})
				.doOnComplete(() -> log.info("Publisher COMPLETE 2"))
				.subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
						e -> log.error("error {}", e.toString()),
						() -> log.info("Subscriber COMPLETE")//,
				);
		Thread.sleep(2000);
	}

	/**
	 * 演示加了 publishOn(Schedulers.elastic()) 发布和订阅在 elastic 线程上
	 */
	private void demo2() throws InterruptedException {
		Flux.range(1, 6)
				.doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
				.publishOn(Schedulers.elastic())
				.doOnComplete(() -> log.info("Publisher COMPLETE 1"))
				.map(i -> {
					log.info("Publish {}, {}", Thread.currentThread(), i);
					return i;
				})
				.doOnComplete(() -> log.info("Publisher COMPLETE 2"))
				.subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
						e -> log.error("error {}", e.toString()),
						() -> log.info("Subscriber COMPLETE")//,
				);
		Thread.sleep(2000);
	}

	/**
	 * 演示异常怎么处理 onErrorReturn
	 */
	private void demo3() throws InterruptedException {
		Flux.range(1, 6)
				.doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
				.publishOn(Schedulers.elastic())
				.doOnComplete(() -> log.info("Publisher COMPLETE 1"))
				.map(i -> {
					log.info("Publish {}, {}", Thread.currentThread(), i);
					return 10 / (i - 3);
				})
				.doOnComplete(() -> log.info("Publisher COMPLETE 2"))
				.subscribeOn(Schedulers.single())
				.onErrorReturn(-1)
				.subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
						e -> log.error("error {}", e.toString()),
						() -> log.info("Subscriber COMPLETE")//,
				);
		Thread.sleep(2000);
	}

	/**
	 * 演示 onErrorResume
	 */
	private void demo4() throws InterruptedException {
		Flux.range(1, 6)
				.doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
				.publishOn(Schedulers.elastic())
				.doOnComplete(() -> log.info("Publisher COMPLETE 1"))
				.map(i -> {
					log.info("Publish {}, {}", Thread.currentThread(), i);
					return 10 / (i - 3);
				})
				.doOnComplete(() -> log.info("Publisher COMPLETE 2"))
				.subscribeOn(Schedulers.single())
				.onErrorResume(e -> {
					log.error("Exception {}", e.toString());
					return Mono.just(-1);
				})
				.onErrorReturn(-1)
				.subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
						e -> log.error("error {}", e.toString()),
						() -> log.info("Subscriber COMPLETE")//,
				);
		Thread.sleep(2000);
	}

	/**
	 * 演示  subscribe 中 subscriptionConsumer 参数
	 */
	private void demo5() throws InterruptedException {
		Flux.range(1, 6)
				.doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
				.publishOn(Schedulers.elastic())
				.doOnComplete(() -> log.info("Publisher COMPLETE 1"))
				.map(i -> {
					log.info("Publish {}, {}", Thread.currentThread(), i);
					return i;
				})
				.doOnComplete(() -> log.info("Publisher COMPLETE 2"))
				.subscribeOn(Schedulers.single())
				.onErrorResume(e -> {
					log.error("Exception {}", e.toString());
					return Mono.just(-1);
				})
				.subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
						e -> log.error("error {}", e.toString()),
						() -> log.info("Subscriber COMPLETE"),
						s -> s.request(4)
				);
		Thread.sleep(2000);
	}

}
