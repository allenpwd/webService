#### 部署axis到tomcat
- 下载axis部署包：http://archive.apache.org/dist/ws/axis/1_4/
- 解压后将webapps下的axis路径全部复制到Tomcat的Webapps下即可
- 访问http://127.0.0.1:8080/axis，点击validation，验证是否有组件未安装

#### 即时发布 jws
将java源代码后缀.java改成.jws后放到wxis目录下，请求http://127.0.0.1:8080/axis/XXX.jws
点击Click to see the WSDL，能看到WSDL描述文件即表示发布成功

##### 遇到问题
看不到WSDL描述文件，报错
```
java.lang.RuntimeException: No compiler found in your classpath!  (you may need to add 'tools.jar')
```
暂不知道怎么解决，这个很旧，应该没人用了，所以不管了
