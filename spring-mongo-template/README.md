### PPT
第4章.pdf

### 视频
25丨在 Spring 中访问 MongoDB.mp4

### 初始化
```bash
use springbucks;

db.createUser(
	{
	    "user": "springbucks",
	    "pwd": "springbucks",
	    "roles": [
	        {
	            "role": "readWrite",
	            "db": "springbucks"
	        }
	    ]
	}
)

show users;
```