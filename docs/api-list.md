#### 项目接口域名：http://193.112.59.11:8080/shortUrl
#### 接口规范说明: 
- 接口域名请根据具体情况修改；
- 接口提交参数如不做特别说明，均以JSON的方式提交数据，以JSON的格式返回结果。  
- 参数定义规范：参数定义应全部用驼峰法
- 符号说明：
   `url`:			请求地址
  `description`:		接口描述
  `method`:		http请求方式
  `login`:		该请求是否需要登录(is required token in headers ?)
  `argument`:		请求携带参数
  `key`:			参数名
  `is_required`:		参数是否必须
  `type`:			参数类型
  `illustration`：		参数说明
  `response`:		请求成功数据返回格式
  `GET`url中的`{value}`表示参数值

-  接口需要登录才能访问时，在请求头加上token值，属性名为'Token'

#### 注册接口
- **url：** ` /user/register`
- **description：**  用户注册
- **method：** POST
- **login：** false
- **request_argument：**

|key|is_required|type|illustration|
|:----    |:---|:----- |:-----   |
|username |是  |string |用户名   |
|password |是  |string |密码     |

- **response(success):**
``` 
{
  "code": 200,
  "message": "success"
}
```

#### 登录接口
- **url：** ` /user/login`
- **description：**  用户登录
- **method：** POST
- **login：** false
- **request_argument：**

|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|username |是  |string |用户名   |
|password |是  |string |密码     |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "user": {
            "username": "pinnuli",
            "createShortUrlCount": 32,
            "visitShortUrlCount": 23,
            "token": "d48d3a183c13465589a26076c99569e5",
            "admin": true
        }
    }
}
```

#### 登出接口
- **url：** ` /user/logout`
- **description：**  用户退出登录
- **method：** POST
- **login：** true
- **response(success):**
``` 
{
  "code": 200,
  "message": "success"
}
```

#### 获取用户信息接口
- **url：** ` /user?currentPage=`
- **description：**  管理员获取普通用户信息接口
- **method：** GET
- **login：** true
- **request_argument：**

|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|currentPage |是  |int |页数   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "userList": [
            {
                "userId": 3,
                "username": "pinnuli",
                "createShortUrlCount": 32,
                "visitShortUrlCount": 23,
                "admin": true,
                "black": false
            },
            {
                "userId": 4,
                "username": "admin",
                "createShortUrlCount": 0,
                "visitShortUrlCount": 0,
                "admin": false,
                "black": false
            }
        ],
        "pageInfo": {
            "totalNumber": 7,
            "currentPage": 1,
            "totalPage": 1,
            "pageNumber": 15,
            "dbIndex": 0,
            "dbNumber": 15
        }
    }
}
```

#### 获取管理员用户信息接口
- **url：** ` /user/admin?currentPage=`
- **description：**  获取黑名单用户信息
- **method：** GET
- **login：** true
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|currentPage |是  |int |页数   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "adminList": [
            {
                "userId": 3,
                "username": "pinnuli",
                "createShortUrlCount": 32,
                "visitShortUrlCount": 23
            },
            {
                "userId": 6,
                "username": "zcy",
                "createShortUrlCount": 40,
                "visitShortUrlCount": 14
            }
        ],
        "pageInfo": {
            "totalNumber": 2,
            "currentPage": 1,
            "totalPage": 1,
            "pageNumber": 15,
            "dbIndex": 0,
            "dbNumber": 15
        }
    }
}
```

#### 设置管理员接口
- **url：** ` /user/admin`
- **description：**  设置用户为管理员
- **method：** POST
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|userId |是  |int |用户id   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```

#### 取消管理员接口
- **url：** ` /user/black_list`
- **description：**  取消管理员资格
- **method：** DELETE
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|userId |是  |int |用户id   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```


#### 获取黑名单用户信息接口
- **url：** ` /user/black_list?currentPage=`
- **description：**  获取黑名单用户信息
- **method：** GET
- **login：** true
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|currentPage |是  |int |页数   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "blackList": [
            {
                "userId": 7,
                "username": "123",
                "createShortUrlCount": 0,
                "visitShortUrlCount": 0,
                "admin": false
            }
        ],
        "pageInfo": {
            "totalNumber": 1,
            "currentPage": 1,
            "totalPage": 1,
            "pageNumber": 15,
            "dbIndex": 0,
            "dbNumber": 15
        }
    }
}
```

#### 设置用户黑名单接口
- **url：** ` /user/black_list`
- **description：**  添加用户到黑名单
- **method：** POST
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|userId |是  |int |用户id   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```

#### 取消黑名单接口
- **url：** ` /user/black_list`
- **description：**  将用户从黑名单删除
- **method：** DELETE
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|userId |是  |int |用户id   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```

#### 短网址生成接口
- **url：** ` /short_url/creation`
- **description：**  生成短网址
- **method：** POST
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|longUrl |是  |string |长网址   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "shortUrl": "5s5gnD5"
    }
}
```

#### 短网址还原接口
- **url：** ` /short_url/visit`
- **description：**  还原短网址
- **method：** GET
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|shortUrl |是  |string |短网址   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "longUrl": "https://blog.csdn.net/realjh/article/details/82048492"
    }
}
```

#### 短网址创建报表接口
- **url：** ` /short_url/report/creation?userId=`
- **description：**  查询时间段内短网址生成数量
- **method：** GET
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|userId |否  |int |用户id   |
|startDate |是  |string |开始日期,格式为yyyy-MM-dd   |
|endDate |是  |string |结束日期,格式为yyyy-MM-dd   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "createReportList": [
            {
                "createDate": "2019-06-14",
                "createCount": 4
            },
            {
                "createDate": "2019-06-15",
                "createCount": 2
            },
            {
                "createDate": "2019-06-17",
                "createCount": 4
            },
            {
                "createDate": "2019-06-18",
                "createCount": 2
            },
            {
                "createDate": "2019-06-19",
                "createCount": 10
            }
        ]
    }
}
```

#### 短网址访问报表接口
- **url：** ` /short_url/report/visit?userId=`
- **description：**  查询时间段内短网址访问数量
- **method：** GET
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|userId |否  |int |用户id   |
|startDate |是  |string |开始日期,格式为yyyy-MM-dd   |
|endDate |是  |string |结束日期,格式为yyyy-MM-dd   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "visitReportList": [
            {
                "date": "2019-06-14",
                "visitCount": 0
            },
            {
                "date": "2019-06-15",
                "visitCount": 0
            },
            {
                "date": "2019-06-17",
                "visitCount": 3
            },
            {
                "date": "2019-06-18",
                "visitCount": 0
            },
            {
                "date": "2019-06-19",
                "visitCount": 18
            }
        ]
    }
}
```

#### api简略信息列表接口
- **url：** ` /api/outline`
- **description：**  api简略信息列表
- **method：** GET
- **login：** true
- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "outlineApiList": [
            {
                "apiId": 1,
                "illustration": "短网址生成接口",
                "requestAddress": "http://localhost:8080/shortUrl/short_url/creation",
                "requestMethod": "POST",
                "contentType": "application/json; charset=UTF-8\r\napplication/json; charset=UTF-8"
            },
            {
                "apiId": 2,
                "illustration": "短网址还原接口",
                "requestAddress": "http://localhost:8080/shortUrl/short_url/visit",
                "requestMethod": "GET",
                "contentType": "application/json; charset=UTF-8"
            }
        ]
    }
}
```

#### api详细信息列表接口
- **url：** ` /api/detail`
- **description：**  api详细信息列表
- **method：** GET
- **login：** true
- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "apiDetailList": [
            {
                "apiId": 1,
                "illustration": "短网址生成接口",
                "requestAddress": "http://localhost:8080/shortUrl/short_url/creation",
                "requestMethod": "POST",
                "contentType": "application/json; charset=UTF-8\r\napplication/json; charset=UTF-8",
                "requestBodyParameterList": [
                    {
                        "name": "longUrl",
                        "type": "string",
                        "illustration": "长网址\t",
                        "example": "\"http://www.baidu.com\""
                    }
                ],
                "requestHeaderParameterList": [
                    {
                        "name": "Token",
                        "type": "string",
                        "illustration": "由数字和字母组成的32位字符",
                        "example": "\"274e88761d6f47b2a718ea9df9d03afb\""
                    }
                ],
                "requestExampleList": [
                    {
                        "language": "Java",
                        "content": "    import java.io.IOException;\r\n    import java.io.OutputStreamWriter;\r\n    import java.net.HttpURLConnection;\r\n    import java.net.URL;\r\n    import java.io.BufferedReader;\r\n    import java.io.InputStreamReader;\r\n    \r\n    import com.google.gson.Gson;\r\n    import com.google.gson.annotations.SerializedName;\r\n    \r\n    public class BaiduDwz {\r\n        final static String CREATE_API = \"http://localhost:8080/shortUrl/short_url/creation\";\r\n        final static String TOKEN = \"你的token\"; // TODO:设置Token\r\n    \r\n        class UrlResponse {\r\n            @SerializedName(\"Code\")\r\n            private int code;\r\n    \r\n            @SerializedName(\"ErrMsg\")\r\n            private String errMsg;\r\n    \r\n            @SerializedName(\"LongUrl\")\r\n            private String longUrl;\r\n    \r\n            @SerializedName(\"ShortUrl\")\r\n            private String shortUrl;\r\n    \r\n            public int getCode() {\r\n                return code;\r\n            }\r\n    \r\n            public void setCode(int code) {\r\n                this.code = code;\r\n            }\r\n    \r\n            public String getErrMsg() {\r\n                return errMsg;\r\n            }\r\n    \r\n            public void setErrMsg(String errMsg) {\r\n                this.errMsg = errMsg;\r\n            }\r\n    \r\n            public String getLongUrl() {\r\n                return longUrl;\r\n            }\r\n    \r\n            public void setLongUrl(String longUrl) {\r\n                this.longUrl = longUrl;\r\n            }\r\n    \r\n            public String getShortUrl() {\r\n                return shortUrl;\r\n            }\r\n    \r\n            public void setShortUrl(String shortUrl) {\r\n                this.shortUrl = shortUrl;\r\n            }\r\n        }\r\n    \r\n        /**\r\n         * 创建短网址\r\n         *\r\n         * @param longUrl\r\n         *            长网址：即原网址\r\n         * @return  成功：短网址\r\n         *          失败：返回空字符串\r\n         */\r\n        public static String createShortUrl(String longUrl) {\r\n            String params = \"{\\\"url\\\":\\\"\"+ longUrl + \"\\\"}\";\r\n    \r\n            BufferedReader reader = null;\r\n            try {\r\n                // 创建连接\r\n                URL url = new URL(CREATE_API);\r\n                HttpURLConnection connection = (HttpURLConnection) url.openConnection();\r\n                connection.setDoOutput(true);\r\n                connection.setDoInput(true);\r\n                connection.setUseCaches(false);\r\n                connection.setInstanceFollowRedirects(true);\r\n                connection.setRequestMethod(\"POST\"); // 设置请求方式\r\n                connection.setRequestProperty(\"Content-Type\", \"application/json\"); // 设置发送数据的格式\r\n                connection.setRequestProperty(\"Token\", TOKEN); // 设置发送数据的格式\");\r\n    \r\n                // 发起请求\r\n                connection.connect();\r\n                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), \"UTF-8\"); // utf-8编码\r\n                out.append(params);\r\n                out.flush();\r\n                out.close();\r\n    \r\n                // 读取响应\r\n                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), \"UTF-8\"));\r\n                String line;\r\n                String res = \"\";\r\n                while ((line = reader.readLine()) != null) {\r\n                    res += line;\r\n                }\r\n                reader.close();\r\n    \r\n                // 抽取生成短网址\r\n                UrlResponse urlResponse = new Gson().fromJson(res, UrlResponse.class);\r\n                if (urlResponse.getCode() == 0) {\r\n                    return urlResponse.getShortUrl();\r\n                } else {\r\n                    System.out.println(urlResponse.getErrMsg());\r\n                }\r\n    \r\n                return \"\"; // TODO：自定义错误信息\r\n            } catch (IOException e) {\r\n                // TODO\r\n                e.printStackTrace();\r\n            }\r\n            return \"\"; // TODO：自定义错误信息\r\n        }\r\n    \r\n        public static void main(String[] args) {\r\n            String res = createShortUrl(\"你的长网址\");\r\n            System.out.println(res);\r\n    \r\n        }\r\n    \r\n    }"
                    },
                    {
                        "language": "curl",
                        "content": "    curl -H \"Content-Type:application/json\" -H \"Token: 你的token\" -X POST \"http://localhost:8080/shortUrl/short_url/creation\" -d '{\"url\":\"你的长网址\"}'"
                    },
                    ...
                ],
                "responseExample": "{\r\n    \"code\": 200,\r\n    \"message\": \"success\",\r\n    \"data\": {\r\n        \"shortUrl\": \"5s5gnD5\"\r\n    }\r\n}",
                "responseParameterList": [
                    {
                        "name": "longUrl",
                        "type": "string",
                        "illustration": "长网址"
                    }
                ]
            },
            ...
        ]
    }
}
```

#### api详细信息接口
- **url：** ` /api/detail/{apiId}`
- **description：**  api详细信息
- **method：** GET
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|apiId |是  |int |接口id   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "detailApi": {
            "apiId": 1,
            "illustration": "短网址生成接口",
            "requestAddress": "http://localhost:8080/shortUrl/short_url/creation",
            "requestMethod": "POST",
            "contentType": "application/json; charset=UTF-8\r\napplication/json; charset=UTF-8",
            "requestBodyParameterList": [
                {
                    "name": "longUrl",
                    "type": "string",
                    "illustration": "长网址\t",
                    "example": "\"http://www.baidu.com\""
                }
            ],
            "requestHeaderParameterList": [
                {
                    "name": "Token",
                    "type": "string",
                    "illustration": "由数字和字母组成的32位字符",
                    "example": "\"274e88761d6f47b2a718ea9df9d03afb\""
                }
            ],
            "requestExampleList": [
                {
                    "language": "Java",
                    "content": "    import java.io.IOException;\r\n    import java.io.OutputStreamWriter;\r\n    import java.net.HttpURLConnection;\r\n    import java.net.URL;\r\n    import java.io.BufferedReader;\r\n    import java.io.InputStreamReader;\r\n    \r\n    import com.google.gson.Gson;\r\n    import com.google.gson.annotations.SerializedName;\r\n    \r\n    public class BaiduDwz {\r\n        final static String CREATE_API = \"http://localhost:8080/shortUrl/short_url/creation\";\r\n        final static String TOKEN = \"你的token\"; // TODO:设置Token\r\n    \r\n        class UrlResponse {\r\n            @SerializedName(\"Code\")\r\n            private int code;\r\n    \r\n            @SerializedName(\"ErrMsg\")\r\n            private String errMsg;\r\n    \r\n            @SerializedName(\"LongUrl\")\r\n            private String longUrl;\r\n    \r\n            @SerializedName(\"ShortUrl\")\r\n            private String shortUrl;\r\n    \r\n            public int getCode() {\r\n                return code;\r\n            }\r\n    \r\n            public void setCode(int code) {\r\n                this.code = code;\r\n            }\r\n    \r\n            public String getErrMsg() {\r\n                return errMsg;\r\n            }\r\n    \r\n            public void setErrMsg(String errMsg) {\r\n                this.errMsg = errMsg;\r\n            }\r\n    \r\n            public String getLongUrl() {\r\n                return longUrl;\r\n            }\r\n    \r\n            public void setLongUrl(String longUrl) {\r\n                this.longUrl = longUrl;\r\n            }\r\n    \r\n            public String getShortUrl() {\r\n                return shortUrl;\r\n            }\r\n    \r\n            public void setShortUrl(String shortUrl) {\r\n                this.shortUrl = shortUrl;\r\n            }\r\n        }\r\n    \r\n        /**\r\n         * 创建短网址\r\n         *\r\n         * @param longUrl\r\n         *            长网址：即原网址\r\n         * @return  成功：短网址\r\n         *          失败：返回空字符串\r\n         */\r\n        public static String createShortUrl(String longUrl) {\r\n            String params = \"{\\\"url\\\":\\\"\"+ longUrl + \"\\\"}\";\r\n    \r\n            BufferedReader reader = null;\r\n            try {\r\n                // 创建连接\r\n                URL url = new URL(CREATE_API);\r\n                HttpURLConnection connection = (HttpURLConnection) url.openConnection();\r\n                connection.setDoOutput(true);\r\n                connection.setDoInput(true);\r\n                connection.setUseCaches(false);\r\n                connection.setInstanceFollowRedirects(true);\r\n                connection.setRequestMethod(\"POST\"); // 设置请求方式\r\n                connection.setRequestProperty(\"Content-Type\", \"application/json\"); // 设置发送数据的格式\r\n                connection.setRequestProperty(\"Token\", TOKEN); // 设置发送数据的格式\");\r\n    \r\n                // 发起请求\r\n                connection.connect();\r\n                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), \"UTF-8\"); // utf-8编码\r\n                out.append(params);\r\n                out.flush();\r\n                out.close();\r\n    \r\n                // 读取响应\r\n                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), \"UTF-8\"));\r\n                String line;\r\n                String res = \"\";\r\n                while ((line = reader.readLine()) != null) {\r\n                    res += line;\r\n                }\r\n                reader.close();\r\n    \r\n                // 抽取生成短网址\r\n                UrlResponse urlResponse = new Gson().fromJson(res, UrlResponse.class);\r\n                if (urlResponse.getCode() == 0) {\r\n                    return urlResponse.getShortUrl();\r\n                } else {\r\n                    System.out.println(urlResponse.getErrMsg());\r\n                }\r\n    \r\n                return \"\"; // TODO：自定义错误信息\r\n            } catch (IOException e) {\r\n                // TODO\r\n                e.printStackTrace();\r\n            }\r\n            return \"\"; // TODO：自定义错误信息\r\n        }\r\n    \r\n        public static void main(String[] args) {\r\n            String res = createShortUrl(\"你的长网址\");\r\n            System.out.println(res);\r\n    \r\n        }\r\n    \r\n    }"
                },
                {
                    "language": "curl",
                    "content": "    curl -H \"Content-Type:application/json\" -H \"Token: 你的token\" -X POST \"http://localhost:8080/shortUrl/short_url/creation\" -d '{\"url\":\"你的长网址\"}'"
                },
                ...
            ],
            "responseExample": "{\r\n    \"code\": 200,\r\n    \"message\": \"success\",\r\n    \"data\": {\r\n        \"shortUrl\": \"5s5gnD5\"\r\n    }\r\n}",
            "responseParameterList": [
                {
                    "name": "longUrl",
                    "type": "string",
                    "illustration": "长网址"
                }
            ]
        }
    }
}
```

#### 添加api信息接口
- **url：** ` /api`
- **description：**  添加api信息
- **method：** POST
- **login：** true
- **request_argument**
``` 
{
  "illustration": "添加api信息接口",
    "requestAddress": "http://localhost:8080/shortUrl/api",
    "requestMethod": "POST",
    "contentType": "application/json; charset=UTF-8\r\napplication/json; charset=UTF-8",
    "requestBodyParameterList": [
        {
            "name": "illustration",
            "type": "string",
            "illustration": "接口描述\t",
            "example": "\"http://www.baidu.com\"",
            "isRequired": true
        }
    ],
    "requestHeaderParameterList": [
        {
            "name": "Token",
            "type": "string",
            "illustration": "由数字和字母组成的32位字符",
            "example": "\"274e88761d6f47b2a718ea9df9d03afb\"",
            "isRequired": true
        }
    ],
    "requestExampleList": [
        {
            "language": "Java",
            "content": "    import java.io.IOException;\r\n    import java.io.OutputStreamWriter;\r\n    import java.net.HttpURLConnection;\r\n    import java.net.URL;\r\n    import java.io.BufferedReader;\r\n    import java.io.InputStreamReader;\r\n    \r\n    import com.google.gson.Gson;\r\n    import com.google.gson.annotations.SerializedName;\r\n    \r\n    public class BaiduDwz {\r\n        final static String CREATE_API = \"http://localhost:8080/shortUrl/short_url/creation\";\r\n        final static String TOKEN = \"你的token\"; // TODO:设置Token\r\n    \r\n        class UrlResponse {\r\n            @SerializedName(\"Code\")\r\n            private int code;\r\n    \r\n            @SerializedName(\"ErrMsg\")\r\n            private String errMsg;\r\n    \r\n            @SerializedName(\"LongUrl\")\r\n            private String longUrl;\r\n    \r\n            @SerializedName(\"ShortUrl\")\r\n            private String shortUrl;\r\n    \r\n            public int getCode() {\r\n                return code;\r\n            }\r\n    \r\n            public void setCode(int code) {\r\n                this.code = code;\r\n            }\r\n    \r\n            public String getErrMsg() {\r\n                return errMsg;\r\n            }\r\n    \r\n            public void setErrMsg(String errMsg) {\r\n                this.errMsg = errMsg;\r\n            }\r\n    \r\n            public String getLongUrl() {\r\n                return longUrl;\r\n            }\r\n    \r\n            public void setLongUrl(String longUrl) {\r\n                this.longUrl = longUrl;\r\n            }\r\n    \r\n            public String getShortUrl() {\r\n                return shortUrl;\r\n            }\r\n    \r\n            public void setShortUrl(String shortUrl) {\r\n                this.shortUrl = shortUrl;\r\n            }\r\n        }\r\n    \r\n        /**\r\n         * 创建短网址\r\n         *\r\n         * @param longUrl\r\n         *            长网址：即原网址\r\n         * @return  成功：短网址\r\n         *          失败：返回空字符串\r\n         */\r\n        public static String createShortUrl(String longUrl) {\r\n            String params = \"{\\\"url\\\":\\\"\"+ longUrl + \"\\\"}\";\r\n    \r\n            BufferedReader reader = null;\r\n            try {\r\n                // 创建连接\r\n                URL url = new URL(CREATE_API);\r\n                HttpURLConnection connection = (HttpURLConnection) url.openConnection();\r\n                connection.setDoOutput(true);\r\n                connection.setDoInput(true);\r\n                connection.setUseCaches(false);\r\n                connection.setInstanceFollowRedirects(true);\r\n                connection.setRequestMethod(\"POST\"); // 设置请求方式\r\n                connection.setRequestProperty(\"Content-Type\", \"application/json\"); // 设置发送数据的格式\r\n                connection.setRequestProperty(\"Token\", TOKEN); // 设置发送数据的格式\");\r\n    \r\n                // 发起请求\r\n                connection.connect();\r\n                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), \"UTF-8\"); // utf-8编码\r\n                out.append(params);\r\n                out.flush();\r\n                out.close();\r\n    \r\n                // 读取响应\r\n                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), \"UTF-8\"));\r\n                String line;\r\n                String res = \"\";\r\n                while ((line = reader.readLine()) != null) {\r\n                    res += line;\r\n                }\r\n                reader.close();\r\n    \r\n                // 抽取生成短网址\r\n                UrlResponse urlResponse = new Gson().fromJson(res, UrlResponse.class);\r\n                if (urlResponse.getCode() == 0) {\r\n                    return urlResponse.getShortUrl();\r\n                } else {\r\n                    System.out.println(urlResponse.getErrMsg());\r\n                }\r\n    \r\n                return \"\"; // TODO：自定义错误信息\r\n            } catch (IOException e) {\r\n                // TODO\r\n                e.printStackTrace();\r\n            }\r\n            return \"\"; // TODO：自定义错误信息\r\n        }\r\n    \r\n        public static void main(String[] args) {\r\n            String res = createShortUrl(\"你的长网址\");\r\n            System.out.println(res);\r\n    \r\n        }\r\n    \r\n    }"
        },
        {
            "language": "curl",
            "content": "    curl -H \"Content-Type:application/json\" -H \"Token: 你的token\" -X POST \"http://localhost:8080/shortUrl/short_url/creation\" -d '{\"url\":\"你的长网址\"}'"
        },
        {
            "language": "JavaScript",
            "content": "    var ajax = new XMLHttpRequest();\r\n    var token = '你的token';\r\n    var longUrl = '你的长网址';\r\n\r\n    ajax.open('post','http://localhost:8080/shortUrl/short_url/creation', 'true');\r\n\r\n    ajax.setRequestHeader(\"Content-Type\", \"application/json\");\r\n    ajax.setRequestHeader(\"Token\", token);\r\n    \r\n    // 发送请求\r\n    ajax.send(JSON.stringify({\r\n        url: longUrl\r\n    }));\r\n\r\n    ajax.onreadystatechange = function () {\r\n        if (ajax.readyState === 4 && ajax.status === 200) {\r\n            // 获取缩短后的网址\r\n            console.log(ajax.responseText);\r\n        }\r\n    }"
        },
        {
            "language": "PHP",
            "content": "    <?php\r\n    $host = 'http://localhost:8080/shortUrl';\r\n    $path = '/short_url/creation';\r\n    $url = $host . $path;\r\n    $method = 'POST';\r\n    $content_type = 'application/json';\r\n    \r\n    // TODO: 设置Token\r\n    $token = '你的Token';\r\n    \r\n    // TODO：设置待注册长网址\r\n    $bodys = array('url'=>'你的长网址'); \r\n    \r\n    // 配置headers \r\n    $headers = array('Content-Type:'.$content_type, 'Token:'.$token);\r\n    \r\n    // 创建连接\r\n    $curl = curl_init($url);\r\n    curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $method);\r\n    curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);\r\n    curl_setopt($curl, CURLOPT_FAILONERROR, false);\r\n    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\r\n    curl_setopt($curl, CURLOPT_HEADER, false);\r\n    curl_setopt($curl, CURLOPT_POST, true);\r\n    curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($bodys));\r\n    \r\n    // 发送请求\r\n    $response = curl_exec($curl);\r\n    curl_close($curl);\r\n    \r\n    // 读取响应\r\n    var_dump($response);\r\n    ?>"
        },
        {
            "language": "Python",
            "content": "    #!/usr/bin/python\r\n    # -*- coding: utf-8 -*-\r\n    import requests\r\n    import json\r\n    \r\n    host = 'http://localhost:8080/shortUrl'\r\n    path = '/short_url/creation'\r\n    url = host + path\r\n    method = 'POST'\r\n    content_type = 'application/json'\r\n    \r\n    # TODO: 设置Token\r\n    token = '你的token'\r\n    \r\n    # TODO：设置待创建的长网址\r\n    bodys = {'url':'你的长网址'}\r\n    \r\n    # 配置headers\r\n    headers = {'Content-Type':content_type, 'Token':token}\r\n    \r\n    # 发起请求\r\n    response = requests.post(url=url, data=json.dumps(bodys), headers=headers)\r\n    \r\n    # 读取响应\r\n    print(response.text)"
        },
        {
            "language": "kotlin",
            "content": "testKotlin"
        },
        {
            "language": "test",
            "content": "test"
        }
    ],
    "responseExample": "{\r\n    \"code\": 200,\r\n    \"message\": \"success\",\r\n    \"data\": {\r\n        \"shortUrl\": \"5s5gnD5\"\r\n    }\r\n}",
    "responseParameterList": [
        {
            "name": "longUrl",
            "type": "string",
            "illustration": "长网址"
        }
    ]
}
```

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```

#### 修改api信息接口
- **url：** ` /api`
- **description：**  修改api信息
- **method：** PUT
- **login：** true
- **request_argument**
``` 
{
  "apiId":14,
  "illustration": "添加api信息接口",
    "requestAddress": "http://localhost:8080/shortUrl/api",
    "requestMethod": "POST",
    "contentType": "application/json; charset=UTF-8\r\napplication/json; charset=UTF-8",
    "requestBodyParameterList": [
        {
            "name": "illustration",
            "type": "string",
            "illustration": "接口描述\t",
            "example": "添加api信息接口",
            "isRequired": true
        }
    ],
    "requestHeaderParameterList": [
        {
            "name": "Token",
            "type": "string",
            "illustration": "由数字和字母组成的32位字符",
            "example": "\"274e88761d6f47b2a718ea9df9d03afb\"",
            "isRequired": true
        }
    ],
    "requestExampleList": [
        {
            "language": "Java",
            "content": "    import java.io.IOException;\r\n    import java.io.OutputStreamWriter;\r\n    import java.net.HttpURLConnection;\r\n    import java.net.URL;\r\n    import java.io.BufferedReader;\r\n    import java.io.InputStreamReader;\r\n    \r\n    import com.google.gson.Gson;\r\n    import com.google.gson.annotations.SerializedName;\r\n    \r\n    public class BaiduDwz {\r\n        final static String CREATE_API = \"http://localhost:8080/shortUrl/short_url/creation\";\r\n        final static String TOKEN = \"你的token\"; // TODO:设置Token\r\n    \r\n        class UrlResponse {\r\n            @SerializedName(\"Code\")\r\n            private int code;\r\n    \r\n            @SerializedName(\"ErrMsg\")\r\n            private String errMsg;\r\n    \r\n            @SerializedName(\"LongUrl\")\r\n            private String longUrl;\r\n    \r\n            @SerializedName(\"ShortUrl\")\r\n            private String shortUrl;\r\n    \r\n            public int getCode() {\r\n                return code;\r\n            }\r\n    \r\n            public void setCode(int code) {\r\n                this.code = code;\r\n            }\r\n    \r\n            public String getErrMsg() {\r\n                return errMsg;\r\n            }\r\n    \r\n            public void setErrMsg(String errMsg) {\r\n                this.errMsg = errMsg;\r\n            }\r\n    \r\n            public String getLongUrl() {\r\n                return longUrl;\r\n            }\r\n    \r\n            public void setLongUrl(String longUrl) {\r\n                this.longUrl = longUrl;\r\n            }\r\n    \r\n            public String getShortUrl() {\r\n                return shortUrl;\r\n            }\r\n    \r\n            public void setShortUrl(String shortUrl) {\r\n                this.shortUrl = shortUrl;\r\n            }\r\n        }\r\n    \r\n        /**\r\n         * 创建短网址\r\n         *\r\n         * @param longUrl\r\n         *            长网址：即原网址\r\n         * @return  成功：短网址\r\n         *          失败：返回空字符串\r\n         */\r\n        public static String createShortUrl(String longUrl) {\r\n            String params = \"{\\\"url\\\":\\\"\"+ longUrl + \"\\\"}\";\r\n    \r\n            BufferedReader reader = null;\r\n            try {\r\n                // 创建连接\r\n                URL url = new URL(CREATE_API);\r\n                HttpURLConnection connection = (HttpURLConnection) url.openConnection();\r\n                connection.setDoOutput(true);\r\n                connection.setDoInput(true);\r\n                connection.setUseCaches(false);\r\n                connection.setInstanceFollowRedirects(true);\r\n                connection.setRequestMethod(\"POST\"); // 设置请求方式\r\n                connection.setRequestProperty(\"Content-Type\", \"application/json\"); // 设置发送数据的格式\r\n                connection.setRequestProperty(\"Token\", TOKEN); // 设置发送数据的格式\");\r\n    \r\n                // 发起请求\r\n                connection.connect();\r\n                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), \"UTF-8\"); // utf-8编码\r\n                out.append(params);\r\n                out.flush();\r\n                out.close();\r\n    \r\n                // 读取响应\r\n                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), \"UTF-8\"));\r\n                String line;\r\n                String res = \"\";\r\n                while ((line = reader.readLine()) != null) {\r\n                    res += line;\r\n                }\r\n                reader.close();\r\n    \r\n                // 抽取生成短网址\r\n                UrlResponse urlResponse = new Gson().fromJson(res, UrlResponse.class);\r\n                if (urlResponse.getCode() == 0) {\r\n                    return urlResponse.getShortUrl();\r\n                } else {\r\n                    System.out.println(urlResponse.getErrMsg());\r\n                }\r\n    \r\n                return \"\"; // TODO：自定义错误信息\r\n            } catch (IOException e) {\r\n                // TODO\r\n                e.printStackTrace();\r\n            }\r\n            return \"\"; // TODO：自定义错误信息\r\n        }\r\n    \r\n        public static void main(String[] args) {\r\n            String res = createShortUrl(\"你的长网址\");\r\n            System.out.println(res);\r\n    \r\n        }\r\n    \r\n    }"
        },
        {
            "language": "curl",
            "content": "    curl -H \"Content-Type:application/json\" -H \"Token: 你的token\" -X POST \"http://localhost:8080/shortUrl/short_url/creation\" -d '{\"url\":\"你的长网址\"}'"
        },
        {
            "language": "JavaScript",
            "content": "    var ajax = new XMLHttpRequest();\r\n    var token = '你的token';\r\n    var longUrl = '你的长网址';\r\n\r\n    ajax.open('post','http://localhost:8080/shortUrl/short_url/creation', 'true');\r\n\r\n    ajax.setRequestHeader(\"Content-Type\", \"application/json\");\r\n    ajax.setRequestHeader(\"Token\", token);\r\n    \r\n    // 发送请求\r\n    ajax.send(JSON.stringify({\r\n        url: longUrl\r\n    }));\r\n\r\n    ajax.onreadystatechange = function () {\r\n        if (ajax.readyState === 4 && ajax.status === 200) {\r\n            // 获取缩短后的网址\r\n            console.log(ajax.responseText);\r\n        }\r\n    }"
        },
        {
            "language": "PHP",
            "content": "    <?php\r\n    $host = 'http://localhost:8080/shortUrl';\r\n    $path = '/short_url/creation';\r\n    $url = $host . $path;\r\n    $method = 'POST';\r\n    $content_type = 'application/json';\r\n    \r\n    // TODO: 设置Token\r\n    $token = '你的Token';\r\n    \r\n    // TODO：设置待注册长网址\r\n    $bodys = array('url'=>'你的长网址'); \r\n    \r\n    // 配置headers \r\n    $headers = array('Content-Type:'.$content_type, 'Token:'.$token);\r\n    \r\n    // 创建连接\r\n    $curl = curl_init($url);\r\n    curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $method);\r\n    curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);\r\n    curl_setopt($curl, CURLOPT_FAILONERROR, false);\r\n    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\r\n    curl_setopt($curl, CURLOPT_HEADER, false);\r\n    curl_setopt($curl, CURLOPT_POST, true);\r\n    curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($bodys));\r\n    \r\n    // 发送请求\r\n    $response = curl_exec($curl);\r\n    curl_close($curl);\r\n    \r\n    // 读取响应\r\n    var_dump($response);\r\n    ?>"
        },
        {
            "language": "Python",
            "content": "    #!/usr/bin/python\r\n    # -*- coding: utf-8 -*-\r\n    import requests\r\n    import json\r\n    \r\n    host = 'http://localhost:8080/shortUrl'\r\n    path = '/short_url/creation'\r\n    url = host + path\r\n    method = 'POST'\r\n    content_type = 'application/json'\r\n    \r\n    # TODO: 设置Token\r\n    token = '你的token'\r\n    \r\n    # TODO：设置待创建的长网址\r\n    bodys = {'url':'你的长网址'}\r\n    \r\n    # 配置headers\r\n    headers = {'Content-Type':content_type, 'Token':token}\r\n    \r\n    # 发起请求\r\n    response = requests.post(url=url, data=json.dumps(bodys), headers=headers)\r\n    \r\n    # 读取响应\r\n    print(response.text)"
        },
        {
            "language": "kotlin",
            "content": "testKotlin again"
        },
        {
            "language": "js",
            "content": "test"
        }
    ],
    "responseExample": "{\r\n    \"code\": 200,\r\n    \"message\": \"success\",\r\n    \"data\": {\r\n        \"shortUrl\": \"5s5gnD5\"\r\n    }\r\n}",
    "responseParameterList": [
        {
            "name": "longUrl",
            "type": "string",
            "illustration": "长网址"
        }
    ]
}
```

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```


#### 删除api信息接口
- **url：** ` /api`
- **description：**  删除api信息
- **method：** DELETE
- **login：** true
- **request_argument：**
|key|is_required|type|illustration|
|:----    |:---|:----- |-----   |
|apiId |是  |int |API的id   |

- **response(success):**
``` 
{
    "code": 200,
    "message": "success"
}
```