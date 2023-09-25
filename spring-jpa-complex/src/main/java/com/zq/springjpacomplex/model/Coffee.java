package com.zq.springjpacomplex.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "T_MENU")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity implements Serializable {
	private static long serialVersionUID = 1L;


	private String name;

	@Column
	@Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
			parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
	private Money price;

}
