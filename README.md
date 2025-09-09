# wxcloudrun-springboot
[![GitHub license](https://img.shields.io/github/license/WeixinCloud/wxcloudrun-express)](https://github.com/WeixinCloud/wxcloudrun-express)
![GitHub package.json dependency version (prod)](https://img.shields.io/badge/maven-3.6.0-green)
![GitHub package.json dependency version (prod)](https://img.shields.io/badge/jdk-11-green)

微信云托管 Java Springboot 框架模版，实现简单的计数器读写接口，使用云托管 MySQL 读写、记录计数值。

![](https://qcloudimg.tencent-cloud.cn/raw/be22992d297d1b9a1a5365e606276781.png)


## 快速开始
前往 [微信云托管快速开始页面](https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/basic/guide.html)，选择相应语言的模板，根据引导完成部署。

## 本地调试
下载代码在本地调试，请参考[微信云托管本地调试指南](https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/guide/debug/)。

## 实时开发
代码变动时，不需要重新构建和启动容器，即可查看变动后的效果。请参考[微信云托管实时开发指南](https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/guide/debug/dev.html)

## Dockerfile最佳实践
请参考[如何提高项目构建效率](https://developers.weixin.qq.com/miniprogram/dev/wxcloudrun/src/scene/build/speed.html)

## 目录结构说明
~~~
.
├── Dockerfile                      Dockerfile 文件
├── LICENSE                         LICENSE 文件
├── README.md                       README 文件
├── container.config.json           模板部署「服务设置」初始化配置（二开请忽略）
├── mvnw                            mvnw 文件，处理mevan版本兼容问题
├── mvnw.cmd                        mvnw.cmd 文件，处理mevan版本兼容问题
├── pom.xml                         pom.xml文件
├── settings.xml                    maven 配置文件
├── springboot-cloudbaserun.iml     项目配置文件
└── src                             源码目录
    └── main                        源码主目录
        ├── java                    业务逻辑目录
        └── resources               资源文件目录
~~~


## 服务 API 文档

### `GET /api/count`

获取当前计数

#### 请求参数

无

#### 响应结果

- `code`：错误码
- `data`：当前计数值

##### 响应结果示例

```json
{
  "code": 0,
  "data": 42
}
```

#### 调用示例

```
curl https://<云托管服务域名>/api/count
```



### `POST /api/count`

更新计数，自增或者清零

#### 请求参数

- `action`：`string` 类型，枚举值
  - 等于 `"inc"` 时，表示计数加一
  - 等于 `"clear"` 时，表示计数重置（清零）

##### 请求参数示例

```
{
  "action": "inc"
}
```

#### 响应结果

- `code`：错误码
- `data`：当前计数值

##### 响应结果示例

```json
{
  "code": 0,
  "data": 42
}
```

#### 调用示例

```
curl -X POST -H 'content-type: application/json' -d '{"action": "inc"}' https://<云托管服务域名>/api/count
```

### `POST /api/house/submit`

上传房源信息

#### 请求参数

- `id`:`Long`类型，索引
- `longitude`:`BigDecimal`类型，经度
- `latitude`:`BigDecimal`类型，纬度
- `address`:`String`类型，详细地址
- `title`:`String`类型，标题
- `location`:`String`类型，具体地点
- `area`:`String`类型，面积
- `houseType`:`String`类型，房型
- `roomCount`:`int`类型，房间数
- `wechat`:`String`类型，微信
- `phone`:`String`类型，手机号
- `paymentOptions`:`Map<String, BigDecimal>`类型，支付方式与价格映射
- `houseFacilities`:`boolean[]`类型，设施信息
- `videoIds`:`String[]`类型，媒体上传后的UID组

##### 请求参数示例

```
{
  "longitude": 116.404,
  "latitude": 39.915,
  "address": "北京市朝阳区建国门外大街1号",
  "title": "国贸中心豪华公寓",
  "location": "国贸CBD",
  "area": "120",
  "houseType": "三室两厅",
  "roomCount": 3,
  "wechat": "guomao_apartment",
  "phone": "13800138000",
  "paymentOptions": {
    "押一付三": 15000.00,
    "半年付": 28000.00,
    "年付": 50000.00
  },
  "houseFacilities": [true, false, true, true, false, true],
  "videoIds": ["vid123456", "vid789012", "vid345678"]
}
```

#### 响应结果

- `code`：错误码
- `data`：无
- `msg`:信息提示

##### 响应结果示例

```json
{
  "code": 0,
  "msg":"操作成功！"
}
```

#### 调用示例

```
curl -X POST -H 'content-type: application/json' -d '{
  "longitude": 116.404,
  "latitude": 39.915,
  "address": "北京市朝阳区建国门外大街1号",
  "title": "国贸中心豪华公寓",
  "location": "国贸CBD",
  "area": "120",
  "houseType": "三室两厅",
  "roomCount": 3,
  "wechat": "guomao_apartment",
  "phone": "13800138000",
  "paymentOptions": {
    "押一付三": 15000.00,
    "半年付": 28000.00,
    "年付": 50000.00
  },
  "houseFacilities": [true, false, true, true, false, true],
  "videoIds": ["vid123456", "vid789012", "vid345678"]
}' https://<云托管服务域名>/api/house/submit
```

### `GET /api/mark/get`

获取所有标记

#### 请求参数

无

#### 响应结果

- `code`：错误码
- `data`：所有标记
- `msg`:信息提示

##### 响应结果示例

```json
{
  "code": 0,
  "data": 42,
  "msg":"获取所有标记成功"
}
```

#### 调用示例

```
curl https://<云托管服务域名>/api/count
```





## 

## 使用注意

如果不是通过微信云托管控制台部署模板代码，而是自行复制/下载模板代码后，手动新建一个服务并部署，需要在「服务设置」中补全以下环境变量，才可正常使用，否则会引发无法连接数据库，进而导致部署失败。
- MYSQL_ADDRESS
- MYSQL_PASSWORD
- MYSQL_USERNAME
以上三个变量的值请按实际情况填写。如果使用云托管内MySQL，可以在控制台MySQL页面获取相关信息。


## License

[MIT](./LICENSE)
