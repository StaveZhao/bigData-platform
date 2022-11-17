安装依赖：npm install

测试环境 ：npm run serve

正式环境：npm run build

```
bigData-cloud-pro -- 	前端工程
├── node_modules -- 	用来存放包管理工具下载安装的包的文件夹
├── public -- 				公共资源
├── src -- 						源文件
		├── api 					本地静态资源
		├── assets 				本地静态资源
		├── components		业务通用组件
		├── direvtive			工作流相关的js文件
		├── icons					常用标识
		├── layouts 			通用布局，整个网站的共用导航栏，页脚和主体部分; 权限、token获取
		├── utils         工具库（放一些公用方法）
		├── views					页面
		App.vue						入口文件
		main.js 					实例话vue，引入插件，存储全局变
		permission.js 		主要负责全局路由守卫和登录判断量
		element.js        用来element-ui按需引入组件一个汇总的地方
├── .gitignore：g			it配置
├── babel.config.js		转码器
├── package.json			项目依赖文件
├── README.md					说明文档




```

