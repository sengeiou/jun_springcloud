#spring-cloud-client
用于发布项目

已处理：
	目前存在问题：发布后，如果发布失败，执行的命令不能结束，需要解决
	需增加线程监控，发布项目执行shell时，一直卡死问题，超过3分钟，则结束执行的sh文件的进程，是在主线程里面判断是否超时