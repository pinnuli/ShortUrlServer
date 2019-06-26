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
  `isrequired`:		参数是否必须
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

|key|isrequired|type|illustration|
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

|key|isrequired|type|illustration|
|:----    |:---|:----- |-----   |
|username |是  |string |用户名   |
|password |是  |string |密码     |

- **response(success):**
``` 
{
  "code": 200,
  "message": "success",
  "data": {
      "token": "c21492161286469ea60a4e038270b267"
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

#### 短网址生成接口
- **url：** ` /short_url/creation`
- **description：**  生成短网址
- **method：** POST
- **login：** true
- **request_argument：**
|key|isrequired|type|illustration|
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
|key|isrequired|type|illustration|
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
- **url：** ` /short_url/report/creation`
- **description：**  查询时间段内短网址生成数量
- **method：** GET
- **login：** true
- **request_argument：**
|key|isrequired|type|illustration|
|:----    |:---|:----- |-----   |
|startDate |是  |string |开始日期   |
|endDate |是  |string |结束日期   |

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
- **url：** ` /short_url/report/visit`
- **description：**  查询时间段内短网址访问数量
- **method：** GET
- **login：** true
- **request_argument：**
|key|isrequired|type|illustration|
|:----    |:---|:----- |-----   |
|startDate |是  |string |开始日期   |
|endDate |是  |string |结束日期   |

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

#### api信息接口
- **url：** ` /short_url/api`
- **description：**  api信息
- **method：** GET
- **login：** true
- **response(success):**
``` 
{
    "code": 200,
    "message": "success",
    "data": {
        "apiList": [
            {
                "illustration": "短网址还原接口",
                "requestAddress": "http://localhost:8080/shortUrl/short_url/visit",
                "requestMethod": "GET",
                "contentType": "application/json; charset=UTF-8",
                "requestBodyParameterList": [
                    {
                        "name": "shortUrl",
                        "type": "string",
                        "illustration": "短网址",
                        "example": "595gHD5"
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
                        "content": "    import java.io.BufferedReader;\r\n    import java.io.IOException;\r\n    import java.io.InputStreamReader;\r\n    import java.io.OutputStreamWriter;\r\n    import java.net.HttpURLConnection;\r\n    import java.net.URL;\r\n    \r\n    import com.google.gson.Gson;\r\n    import com.google.gson.annotations.SerializedName;\r\n    \r\n    public class BaiduDwz {\r\n        final static String CREATE_API = \"http://localhost:8080/shortUrl/short_url/creation\";\r\n        final static String TOKEN = \"你的token\"; // TODO:设置Token\r\n    \r\n        class UrlResponse {\r\n            @SerializedName(\"Code\")\r\n            private int code;\r\n    \r\n            @SerializedName(\"ErrMsg\")\r\n            private String errMsg;\r\n    \r\n            @SerializedName(\"LongUrl\")\r\n            private String longUrl;\r\n    \r\n            @SerializedName(\"ShortUrl\")\r\n            private String shortUrl;\r\n    \r\n            public int getCode() {\r\n                return code;\r\n            }\r\n    \r\n            public void setCode(int code) {\r\n                this.code = code;\r\n            }\r\n    \r\n            public String getErrMsg() {\r\n                return errMsg;\r\n            }\r\n    \r\n            public void setErrMsg(String errMsg) {\r\n                this.errMsg = errMsg;\r\n            }\r\n    \r\n            public String getLongUrl() {\r\n                return longUrl;\r\n            }\r\n    \r\n            public void setLongUrl(String longUrl) {\r\n                this.longUrl = longUrl;\r\n            }\r\n    \r\n            public String getShortUrl() {\r\n                return shortUrl;\r\n            }\r\n    \r\n            public void setShortUrl(String shortUrl) {\r\n                this.shortUrl = shortUrl;\r\n            }\r\n        }\r\n        /**\r\n         * 还原长网址短网址\r\n         *\r\n         * @param shortUrl 短网址\r\n         * @return  成功：长网址\r\n         *\r\n         */\r\n        public static String queryLongUrl(String shortUrl) {\r\n            String params = \"{\\\"shortUrl\\\":\\\"\"+ shortUrl + \"\\\"}\";\r\n    \r\n            BufferedReader reader = null;\r\n            try {\r\n                // 创建连接\r\n                URL url = new URL(CREATE_API);\r\n                HttpURLConnection connection = (HttpURLConnection) url.openConnection();\r\n                connection.setDoOutput(true);\r\n                connection.setDoInput(true);\r\n                connection.setUseCaches(false);\r\n                connection.setInstanceFollowRedirects(true);\r\n                connection.setRequestMethod(\"POST\"); // 设置请求方式\r\n                connection.setRequestProperty(\"Content-Type\", \"application/json\"); // 设置发送数据的格式\r\n                connection.setRequestProperty(\"Token\", TOKEN); // 设置发送数据的格式\");\r\n    \r\n                // 发起请求\r\n                connection.connect();\r\n                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), \"UTF-8\"); // utf-8编码\r\n                out.append(params);\r\n                out.flush();\r\n                out.close();\r\n    \r\n                // 读取响应\r\n                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), \"UTF-8\"));\r\n                String line;\r\n                String res = \"\";\r\n                while ((line = reader.readLine()) != null) {\r\n                    res += line;\r\n                }\r\n                reader.close();\r\n    \r\n                // 抽取生成长网址\r\n                UrlResponse urlResponse = new Gson().fromJson(res, UrlResponse.class);\r\n                if (urlResponse.getCode() == 0) {\r\n                    return urlResponse.getLongUrl();\r\n                } else {\r\n                    System.out.println(urlResponse.getErrMsg());\r\n                }\r\n    \r\n                return \"\"; // TODO：自定义错误信息\r\n            } catch (IOException e) {\r\n                // TODO\r\n                e.printStackTrace();\r\n            }\r\n            return \"\"; // TODO：自定义错误信息\r\n        }\r\n    \r\n        public static void main(String[] args) {\r\n            String res = queryLongUrl(\"你的短网址\");\r\n            System.out.println(res);\r\n    \r\n        }\r\n    \r\n    } "
                    },
                    {
                        "language": "curl",
                        "content": "    curl -H \"Content-Type:application/json\" -H \"Token: 你的token\" -X POST \"http://localhost:8080/shortUrl/short_url/creation\" -d '{\"shortUrl\":\"你的短网址\"}'"
                    },
                    {
                        "language": "JavaScript",
                        "content": "    var ajax = new XMLHttpRequest();\r\n    var token = '你的token';\r\n    var shortUrl = '你的短网址';\r\n\r\n    ajax.open('post','http://localhost:8080/shortUrl/short_url/creation', 'true');\r\n\r\n    ajax.setRequestHeader(\"Content-Type\", \"application/json\");\r\n    ajax.setRequestHeader(\"Token\", token);\r\n    // 发送请求\r\n    ajax.send(JSON.stringify({\r\n        shortUrl: shortUrl\r\n    }));\r\n\r\n    ajax.onreadystatechange = function () {\r\n        if (ajax.readyState === 4 && ajax.status === 200) {\r\n            // 短网址对应的长网址\r\n            console.log(ajax.responseText);\r\n        }\r\n"
                    },
                    {
                        "language": "PHP",
                        "content": "    <?php\r\n    $host = 'http://localhost:8080/shortUrl';\r\n    $path = '/short_url/creation';\r\n    $url = $host . $path;\r\n    $method = 'POST';\r\n    $content_type = 'application/json';\r\n    \r\n    // TODO: 设置Token\r\n    $token = '你的Token';\r\n    \r\n    // TODO：设置还原的短网址\r\n    $bodys = array('shortUrl'=>'你的短网址');\r\n\r\n    // 设置headers\r\n    $headers = array('Content-Type:'.$content_type, 'Token:'.$token);\r\n    \r\n    // 创建连接\r\n    $curl = curl_init($url);\r\n    curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $method);\r\n    curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);\r\n    curl_setopt($curl, CURLOPT_FAILONERROR, false);\r\n    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\r\n    curl_setopt($curl, CURLOPT_HEADER, false);\r\n    curl_setopt($curl, CURLOPT_POST, true);\r\n    curl_setopt($curl, CURLOPT_POSTFIELDS, json_encode($bodys));\r\n    \r\n    // 发送请求\r\n    $response = curl_exec($curl);\r\n    curl_close($curl);\r\n    \r\n    // 读取响应\r\n    var_dump($response);\r\n    ?>\r\n    "
                    },
                    {
                        "language": "Python",
                        "content": "    #!/usr/bin/python\r\n    # -*- coding: utf-8 -*-\r\n    import requests\r\n    import json\r\n    \r\n    host = 'http://localhost:8080/shortUrl'\r\n    path = '/short_url/creation'\r\n    url = host + path\r\n    method = 'POST'\r\n    content_type = 'application/json'\r\n    \r\n    # TODO: 设置Token\r\n    token = '你的token'\r\n    \r\n    # TODO：设置待还原的短网址\r\n    bodys = {'shortUrl':'你的短网址'}\r\n    \r\n    # 配置headers\r\n    headers = {'Content-Type':content_type, 'Token':token}\r\n    \r\n    # 发起请求\r\n    response = requests.post(url=url, data=json.dumps(bodys), headers=headers)\r\n    \r\n    # 读取响应\r\n    print(response.text)"
                    }
                ],
                "responseExample": "{\n    \"code\": 200,\n    \"message\": \"success\",\n    \"data\": {\n        \"longUrl\": \"https://blog.csdn.net/realjh/article/details/82048492\"\n    }\n}",
                "responseParameterList": [
                    {
                        "name": "shortUrl",
                        "type": "string",
                        "illustration": "短网址"
                    }
                ]
            }
        ]
    }
}
```

