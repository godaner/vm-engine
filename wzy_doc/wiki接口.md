# UserArticleThriftService
 
## 创建新文章
 
### 接口
 
    String createNewArticle( Long uid, Integer type, String dataJson);
    
### 调用示例
 
 * 创建单篇文章

  + uid :

  				10L
  			
  + type:

  				1
  			
  + dataJson:
	
              {
			"accountId": 560,
		    "author": "wstnc1asweid402b64j",
		    "backcontent": "29isekowuy9db6yyl3wtc375h8m",
		    "contentSourceUrl": "8s09970ygfi6ostgvc753a1t",
		    "coverUrl": "ov6gh4ngmzcwkwxqvq",
		    "createTime": 1,
		    "digest": "4t9ojk5ugdjrl86b42d6x6pvz1",
		    "html": "v55b3095p",
		    "id": 717,
		    "status": 5,
		    "showCoverPic": 5,
		    "status": 7,
		    "title": "igr6cts6zsbspgpee",
		    "type": 1,
		    "updateTime": 10,
		    "isSecretMsg": 0}

* 创建公告文章

  + uid :

  			10L
  			
  + type:

  			2
  			
  + dataJson:
 		
		 		{
		    "accountId": 560,
		    "author": "wstnc1asweid402b64j",
		    "backcontent": "29isekowuy9db6yyl3wtc375h8m",
		    "contentSourceUrl": "8s09970ygfi6ostgvc753a1t",
		    "coverUrl": "ov6gh4ngmzcwkwxqvq",
		    "createTime": 1,
		    "digest": "4t9ojk5ugdjrl86b42d6x6pvz1",
		    "ext": "pgdd4ploybo20mzereub8xm1h3e",
		    "html": "v55b3095p",
		    "id": 717,
		    "status": 5,
		    "showCoverPic": 5,
		    "status": 7,
		    "title": "igr6cts6zsbspgpee",
		    "type": 1,
		    "updateTime": 10,
                    "isSecretMsg": 0
			}
	

		ext 为附件字段
		
	
* 创建图文集合

  + uid :

  			10L
  			
  + type:

  			0
  			
  + dataJson:
 		
		 	
		 	[

		    {
		        "accountId": 1,
		        "author": "",
		        "backcontent": "",
		        "contentSourceUrl": "",
		        "coverUrl": "am6j8m9",
		        "createTime": 9,
		        "digest": "",
		        "html": "o5ukj8",
		        "id": 993,
		        "status": 5,
		        "orderInGroup": 3,
		        "showCoverPic": 8,
		        "status": 9,
		        "title": "x26gjtv",
		        "type": 8,
		        "updateTime": 7
		    },
		    {
		        "accountId": 1,
		        "author": "",
		        "backcontent": "",
		        "contentSourceUrl": "",
		        "coverUrl": "ilkb5cz1lk3orf7jg7i",
		        "createTime": 8,
		        "digest": "",
		        "html": "z3giqb6hzp4zgti",
		        "id": 74,
		        "status": 8,
		        "orderInGroup": 4,
		        "showCoverPic": 9,
		        "status": 1,
		        "title": "zzs686hrxux9kt5lqtahxa46j",
		        "type": 10,
		        "updateTime": 3
		    }
			]


		
		
	
	
### 返回
	
	
* 单篇文章返回 （普通文章，公告)
	
		
		{
	    "code": 0,
	    "data": {
	        "saveRes": true,
	        "articleId": 57,
	        "type": 2 //或者 3
	    }
		}

* 多图文返回

		{
		    "code": 0,
		    "data": {
		        "saveRes": true,
		        "artGrpId": 53,
		        "type": 1,
		        "articleIdList": [
		            252,
		            253,
		            254,
		            255,
		            256
		        ]
		    }
		}
	

	

    



## 更新文章
### 接口

String updateArticle( Long uid, Integer type, String dataJson);

    
### 调用示例

* 更新单篇文章 ,或者公告文章


	* uid :

			382L
		
	* type:

			1 -  单篇文章 
			2 - 公告文章

	* dataJson :


					{
				    "accountId": 382,
				    "author": "u1udlg6y18kbhavhv",
				    "backcontent": "k",
				    "contentSourceUrl": "aekli2m6dlq1",
				    "coverUrl": "lz129a2xlqys",
				    "createTime": 1487557892,
				    "digest": "leyga0gkt3oqzbmpnvu4h4lets5",
				    "html": "aslkdjfklajdsfljalsdfjlkasjdflkjadlf说肯定是健康减肥",
				    "id": 31,
				    "status": 0,
				    "showCoverPic": 8,
				    "status": 10,
				    "title": "foxhahahah",
				    "type": 1,
				    "updateTime": 1487557892
				}


* 更新图文集合

	
	* uid :

			382L
		
	* type:

			0 -  图文集合
			
	* dataJson :


					{
		    "articleGrpId": 9,
		    "list": [
		        {
		            "accountId": 1,
		            "author": "testFox",
		            "backcontent": "",
		            "contentSourceUrl": "",
		            "coverUrl": "1jcvzb58cirx4rnoa0r1wd22w0950",
		            "createTime": 1487558518,
		            "digest": "",
		            "html": "bhf8p0274e3sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>",
		            "id": 62,
		            "status": 0,
		            "orderInGroup": 0,
		            "showCoverPic": 4,
		            "status": 0,
		            "title": "test",
		            "type": 0,
		            "updateTime": 1487560793
		        },
		        {
		            "accountId": 1,
		            "author": "testFox",
		            "backcontent": "",
		            "contentSourceUrl": "",
		            "coverUrl": "0g8e1vlb5rd",
		            "createTime": 1487558518,
		            "digest": "",
		            "html": "82w4xoz8vxvsdi9cop00hraxsdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>sdfsdjfksdjfks<dicv..>>>>",
		            "id": 63,
		            "status": 0,
		            "orderInGroup": 1,
		            "showCoverPic": 4,
		            "status": 0,
		            "title": "test",
		            "type": 0,
		            "updateTime": 1487560793
		        }
		    ]
			}


### 返回
			
* 单篇返回

		{
	    "code": 0,
	    "data": {
	        "updateRes": true,
	        "articleId": 45,
	        "type": 2
	    }
		}
		
* 多图文返回

		{
		    "code": 0,
		    "data": {
		        "articleGrpId": 9,
		        "updateRes": true,
		        "type": 1,
		        "articleIdList": [
		            32,
		            33,
		            34,
		            35,
		            36
		        ]
		    }
		}


## 更新文章的封面以及html内容

### 接口

    String updateArticleHtml(Long uid,
                             Integer type,
                            String dataJson );
       
                             
### 调用示例
       
* uid:    
		
			10L 
   		
* type 


				GROUPED(0,"图文集合"),SINGLE(1,"普通文章"),ANNOUNCE(2,"公告");
				

* html

		新的内容(替换html之后)
		

###响应

		{"code":0,"data":{"updateRes":false}} //失败false, 成功true
               		

## 删除文章

### 接口

 
    String deleteArticle( Long uid, Integer type, Long id);

### 调用示例

* uid 

		10L 
	
* type 

				GROUPED(0,"图文集合"),SINGLE(1,"普通文章"),ANNOUNCE(2,"公告");
				
* id

	 	100L
	 	
### 返回

	{"code":0,"data":{"delRes":false}}



## 获取文章列表

### 接口
 
String getArticleList( Long uid, Integer type, String pageBean);

### 调用示例

* 获取单篇图文/公告图文

	* uid: 

		1L 
		
   * type

			1 -  单篇文章 
			2 - 公告文章
			
	* pageBean:

			{"start":0,"size":10,"orderBy":"create_time","orderType":"DESC"}
			
* 获取单篇图文/公告图文返回

		
				{
		    "code": 0,
		    "data": {
		        "total": 15,
		        "list": [
		       
		            {
		                "accountId": 10,
		                "articleType": 1,
		                "author": "qth",
		                "backcontent": "ih",
		                "contentSourceUrl": "8fqe7p1rh5pbqiebok9wrog4",
		                "coverUrl": "h7zdah0q5w41w8ikhgyu",
		                "createTime": 1487578389,
		                "digest": "l0r",
		                "ext": "tu19whekdiuy",
		                "html": "jduedoweb4j7wxe9dcic3s7w7",
		                "id": 893,
		                "status": 0,
		                "showCoverPic": 5,
		                "status": 5,
		                "title": "jnxy2i",
		                "updateTime": 1487578389
		            },
		            {
		                "accountId": 10,
		                "articleType": 1,
		                "author": "ywmr4zne",
		                "backcontent": "xuvppjojhuw39gawk5gu4569yf",
		                "contentSourceUrl": "pm9fvqhbg29ro7ari9r",
		                "coverUrl": "kd9csrbfaah853a1g9suqmo53pm",
		                "createTime": 1487578389,
		                "digest": "5j67ntcu",
		                "ext": "zwivc",
		                "html": "c86c22uqbgubvh",
		                "id": 894,
		                "status": 0,
		                "showCoverPic": 2,
		                "status": 3,
		                "title": "33ykwzl15xkcaspplaic2f06stav",
		                "updateTime": 1487578389
		            },
		            {
		                "accountId": 10,
		                "articleType": 1,
		                "author": "k7bmdwle6kxq3gy0yauosw2n",
		                "backcontent": "qmfzgn2cgv0pms2d4mb6uxs5w",
		                "contentSourceUrl": "zh117g84",
		                "coverUrl": "1mhr2d9",
		                "createTime": 1487578389,
		                "digest": "83mwo68gpkm8o4krx6rtbpjruornx",
		                "ext": "8",
		                "html": "7rwkekjag0kmlusykz0ui86mf6528",
		                "id": 895,
		                "status": 0,
		                "showCoverPic": 7,
		                "status": 6,
		                "title": "r94e6vdcwluyxrhw8",
		                "updateTime": 1487578389
		            }
		        ]
		    }
		}   	


* 获取图文集合列表

	* uid: 

		1L 
		
   * type

			0 - 图文集合 
			
	* pageBean:

				{"start":0,"size":10,"orderBy":"create_time","orderType":"DESC"}
			
			

* 获取图文集合返回:

	
	
				{
		    "code": 0,
		    "data": {
		        "total": 200,
		        "list": [
		        
		            {
		                "accountId": 1,
		                "createTime": 1487558562,
		                "id": 101,
		                "status": 0,
		                "status": 0,
		                "summary": "[{\"coverUrl\":\"d46t520vbx8cred3ropj\",\"title\":\"dxbtq9wjxddz780vz5a\"},{\"coverUrl\":\"rat6ki6hmcbln4pcxsu5qih7wauhf\",\"title\":\"55f3404lct5fm9u8x6\"},{\"coverUrl\":\"z3cljywy6mxrf87tuj9y2comthz4h\",\"title\":\"nmt3k1kcusx9m3jfn2hch02rc\"},{\"coverUrl\":\"ve5pb96e6xvuje86rkaal4w0bt\",\"title\":\"kr6oshualybelsiwecblb9a\"},{\"coverUrl\":\"xkuqlp27427owgqc\",\"title\":\"umfv9p1nhbtxby6wl9mhbfq3\"}]",
		                "updateTime": 1487558562
		            },
		            {
		                "accountId": 1,
		                "createTime": 1487558562,
		                "id": 102,
		                "status": 0,
		                "status": 0,
		                "summary": "[{\"coverUrl\":\"zsfftdf7b\",\"title\":\"73pb3ef92cs\"},{\"coverUrl\":\"x644y\",\"title\":\"fvovchyp0qhkktmzj4h\"},{\"coverUrl\":\"8xm18zvw76diy8hofeyjslwd2jgfp\",\"title\":\"2zpbyy3lb\"},{\"coverUrl\":\"\",\"title\":\"q9v10d\"},{\"coverUrl\":\"co2vo4qu30b9\",\"title\":\"9fu3odxdwmkodv\"}]",
		                "updateTime": 1487558562
		            },
		            {
		                "accountId": 1,
		                "createTime": 1487558562,
		                "id": 103,
		                "status": 0,
		                "status": 0,
		                "summary": "[{\"coverUrl\":\"2orsyh\",\"title\":\"bt\"},{\"coverUrl\":\"nh\",\"title\":\"heudh41\"},{\"coverUrl\":\"5mwbk\",\"title\":\"4yaucajiqoorfqa52daa4t531d9\"},{\"coverUrl\":\"w77puydlt\",\"title\":\"zxzdilkt9ak32b3olvc0\"},{\"coverUrl\":\"2tr233sc5pakp2w37s6v6w81\",\"title\":\"vwr\"}]",
		                "updateTime": 1487558562
		            }
		        ]
		    }
		}



 
## 获取文章详情（单篇文章，公告文章)

### 接口

    String getArticleContent( Long uid, Long articleId);

### 调用示例

* uid 

		1L 
	
* articleId

		100L
		
### 返回

		{
    "code": 0,
    "data": {
        "accountId": 1,
        "articleType": 1,
        "author": "b7jw58dxqecuozq15anactlnrs",
        "backcontent": "hw016k0",
        "contentSourceUrl": "exzgi19sla1maklf851cunys5dma",
        "coverUrl": "dixphir6jsiwp7dvscf25b7c40lj",
        "createTime": 1487581787,
        "digest": "wsuzh0hlzus9pb6ukwxpk2r1za",
        "ext": "",
        "html": "kzmjb",
        "id": 927,
        "status": 0,
        "showCoverPic": 7,
        "status": 6,
        "title": "cjkrkgw",
        "updateTime": 1487581787
    }
	}

   


## 获取图文文章详情列表

### 接口

String getGroupArticleContentList( Long uid, Long articleGrpId);
    
### 调用示例

* uid

	10L 
	
* articleGrpId

	3L

### 返回

		{
		    "code": 0,
		    "data": [
		        {
		            "accountId": 10,
		            "articleType": 0,
		            "coverUrl": "24d49p7yyp2e47fx",
		            "createTime": 1487252898,
		            "html": "1ghvpyb8t74n6tooz7",
		            "id": 24,
		            "status": 0,
		            "orderInGroup": 3,
		            "status": 0,
		            "title": "ick3uhlqbqgqxi64iqoptijk2wv",
		            "updateTime": 1487252898
		        },
		        {
		            "accountId": 10,
		            "articleType": 0,
		            "coverUrl": "9i7katl6ix1sb12",
		            "createTime": 1487252898,
		            "html": "aslkdjfklajdsfljalsdfjlkasjdflkjadlf说肯定是健康减肥",
		            "id": 25,
		            "status": 0,
		            "orderInGroup": 4,
		            "status": 0,
		            "title": "foxhahahah",
		            "updateTime": 1487559785
		        },
		        {
		            "accountId": 10,
		            "articleType": 0,
		            "coverUrl": "5fxvnot6cz3bn8svix7s35",
		            "createTime": 1487252898,
		            "html": "ia",
		            "id": 26,
		            "status": 0,
		            "orderInGroup": 5,
		            "status": 0,
		            "title": "v0i7aglz4e05cfh0ou9s82ziyukq",
		            "updateTime": 1487252898
		        }
		    ]
		}
    
    
## 用户添加图片分组

### 接口

	  
    String addUserImgGroup(Long uid,String newGroupName);
   
   
### 调用示例

* uid 

	668L
	
* newGroupName 组名字

	"测试分组"
	

### 返回

	{
	    "code": 0,
	    "data": {
	        "accountId": 668,
	        "createTime": 1487586616,
	        "groupName": "测试分组",
	        "id": 36,
	        "status": 0,
	        "updateTime": 1487586616
	    }
	}
    
## 用户添加图片分组

### 接口  

    String deleteUserImg(Long uid,
                        Long imgId);

### 调用示例

* uid 

		10L 
	
* imgId

		1001L 
	
	
### 返回

	{"code":0,"data":{"delRes":true}}
	


## 获取用户某分组下图片列表
    
### 接口

	String getUserImgList( Long uid, Long imgGrpId, String pageBean);
	
	
### 调用示例

* uid:

		10L 
	
* imgGrpId  图片分组id

		1L 
* pageBean 分页参数
	
	
		{"start":0,"size":10,"orderBy":"create_time","orderType":"DESC"}
		
### 返回

	{
    "code": 0,
    "data": {
        "total": 20,
        "list": [
          
            {
                "accountId": 668,
                "createTime": 10,
                "groupId": 1,
                "groupName": "gx6xujvs",
                "id": 19,
                "imgUrl": "52rqthx7qwsle",
                "status": 3,
                "updateTime": 4
            },
            {
                "accountId": 668,
                "createTime": 9,
                "groupId": 1,
                "groupName": "cjt0i1fkwtcwpbu8hvf",
                "id": 20,
                "imgUrl": "9lyoywywrdu",
                "status": 1,
                "updateTime": 10
            }
        ]
    }
	}




## 添加图片到用户的指定分组

### 接口
 
	String addUserImg( Long uid, Long imgGrpId, String dataJson);
	
	
### 调用示例
	
* uid

		10L 
		
* imgGrpId 

		1L 
		
* dataJson   批量接口,如果是一张图就传一个，包含在数组里面

		
			[
		    {
		        "groupId": 189,
		        "imgUrl": "i4oj4t"
		    },
		    {
		        "groupId": 834,
		        "imgUrl": "dqb134me"
		    }
		]		
    
   
## 删除图片 
    
   
### 接口
    
	String deleteUserImg( Long uid, Long imgId);


### 调用示例

* uid 

	10L 
	
* imgId 

	100L
	
### 返回

	{"code":0,"data":{"delRes":true}}


## 获取用户图片分组

### 接口    
	
	String getUserImgGroupList( Long uid);

### 调用示例

* uid 

	 668L
	 
### 返回

		{
    "code": 0,
    "data": [
        {
            "accountId": 668,
            "createTime": 1487581818,
            "groupName": "默认分组",
            "id": 1,
            "status": 0,
            "updateTime": 1487581818
        }
    ]
	}




## 删除用户图片分组
   
### 接口
    
	String deleteUserImgGroup( Long uid, Long imgGrpId);
	
### 调用示例
	
* uid 

	10L
	
* imgGrpId

	36L
	
	
### 返回


		{
		    "code": 0,
		    "data": {
		        "delRes": true
		    }
		}


	

## 更新用户图片分组

### 接口
    
	String updateUsrImgGroup( Long uid, Long imgGrpId, String newGrpName);
	
### 调用示例

* uid

	10L
	
* imgGrpId

	37L
	
* newGrpName
		
			{
		    "code": 0,
		    "data": {
		        "updateRes": true
		    }
			}




   
   
## 微擎用户获取别人发送给他的文章 

### 接口

String getReciverArticleList( Long recvId) ;

### 调用示例

* recvId 微擎用户在微政通的账户id

	1L 

### 返回

注意这里会返回所有类型的文章，需要自行判断解析

			{
	    "code": 0,
	    "data": {
	        "GroupList": [
	         
	            {
	                "accountId": 1,
	                "createTime": 1487646167,
	                "id": 28,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":784,\"coverUrl\":\"8jxk2qhvrweuzcc3uugi2hjxe7aa\",\"order\":0,\"title\":\"hjw08slou3\"},{\"articleId\":693,\"coverUrl\":\"pnmrtnguwy6kujzn24\",\"order\":1,\"title\":\"emhnm24c8gn26kaic4m2wh3ggi0k\"},{\"articleId\":72,\"coverUrl\":\"8zdhzisitpmvjwd8d\",\"order\":2,\"title\":\"es\"},{\"articleId\":553,\"coverUrl\":\"0vd27qvnon7fthcb6\",\"order\":3,\"title\":\"hq4m\"},{\"articleId\":683,\"coverUrl\":\"h20q\",\"order\":4,\"title\":\"pqv\"}]",
	                "updateTime": 1487646167
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646167,
	                "id": 29,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":1000,\"coverUrl\":\"ivcvwqsmox3i\",\"order\":0,\"title\":\"pi5gi8vhk8mlu5m699w\"},{\"articleId\":346,\"coverUrl\":\"v54kslezbadmv\",\"order\":1,\"title\":\"2w\"},{\"articleId\":536,\"coverUrl\":\"61izb6n9300g4pdw72vi0xm5s8hw7\",\"order\":2,\"title\":\"zzvb22cdqmh\"},{\"articleId\":641,\"coverUrl\":\"wywclwmnfx01\",\"order\":3,\"title\":\"deykq1al68ywct913lth67a39\"},{\"articleId\":990,\"coverUrl\":\"5i33dudhl8zs9w8gyvjt\",\"order\":4,\"title\":\"rmeuhbt9aw1areya8s0\"}]",
	                "updateTime": 1487646167
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646167,
	                "id": 30,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":805,\"coverUrl\":\"esfgby1ffc5z8j\",\"order\":0,\"title\":\"nio26hlp0x856po3juyt7qfqdax90\"},{\"articleId\":784,\"coverUrl\":\"bsjfwenxi8bw\",\"order\":1,\"title\":\"ez2\"},{\"articleId\":24,\"coverUrl\":\"d7zgj02hvq1v3tgha8qk8hpnjsncn\",\"order\":2,\"title\":\"jrj282us2dqg4lb252\"},{\"articleId\":277,\"coverUrl\":\"23w\",\"order\":3,\"title\":\"24yd0pta6xeu04l0adqzw85zv\"},{\"articleId\":652,\"coverUrl\":\"65fquz5ogo8fns35y678j\",\"order\":4,\"title\":\"xu0ycha2oz6wq3rglzd2gxq8irp\"}]",
	                "updateTime": 1487646167
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646168,
	                "id": 40,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":401,\"coverUrl\":\"0e4wknv4f84c\",\"order\":0,\"title\":\"vurwpbrjudxujgc\"},{\"articleId\":407,\"coverUrl\":\"zahkh0xrq09n6q4rdoyp7\",\"order\":1,\"title\":\"tgf0vsrn0m5n4i3bb\"},{\"articleId\":455,\"coverUrl\":\"b\",\"order\":2,\"title\":\"srzkz0eby0td0nw\"},{\"articleId\":19,\"coverUrl\":\"q\",\"order\":3,\"title\":\"htyp7uh5\"},{\"articleId\":901,\"coverUrl\":\"iqu9g0eehkshikha0tp\",\"order\":4,\"title\":\"ydjy9oj744ve\"}]",
	                "updateTime": 1487646168
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646168,
	                "id": 41,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":845,\"coverUrl\":\"qxhj8rgidoxw\",\"order\":0,\"title\":\"y7pir1z5plbbm\"},{\"articleId\":873,\"coverUrl\":\"ia\",\"order\":1,\"title\":\"731y46gax1mj4eg7omp6prrfyav\"},{\"articleId\":299,\"coverUrl\":\"cwdv30tg4kjnnaw6bsh9j8y8sy\",\"order\":2,\"title\":\"uv1lro43icycnkxtgx4i89cl\"},{\"articleId\":823,\"coverUrl\":\"jphxuk9d2gye\",\"order\":3,\"title\":\"a4kxrkui9ku3w\"},{\"articleId\":851,\"coverUrl\":\"8xj\",\"order\":4,\"title\":\"zeapoo1555ik5dfhrif1mkd\"}]",
	                "updateTime": 1487646168
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646168,
	                "id": 42,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":366,\"coverUrl\":\"p9fjvkckvnxk94qgk5b0tw6\",\"order\":0,\"title\":\"94thrq\"},{\"articleId\":789,\"coverUrl\":\"f6e0gr9s9t912\",\"order\":1,\"title\":\"nasjmdlmgwezf5e\"},{\"articleId\":440,\"coverUrl\":\"\",\"order\":2,\"title\":\"jn491kp63zmvmoax\"},{\"articleId\":401,\"coverUrl\":\"houq170jqfm9ik39fevqpl2q66\",\"order\":3,\"title\":\"ij75csvk6y1dmjdjqe7\"},{\"articleId\":250,\"coverUrl\":\"sfrrzz59aw1n4psh68q7y2\",\"order\":4,\"title\":\"zgu34qawbkguatqqfd54hwsz\"}]",
	                "updateTime": 1487646168
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 43,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":211,\"coverUrl\":\"62a9df8rkcua81glzrt1h\",\"order\":0,\"title\":\"573\"},{\"articleId\":212,\"coverUrl\":\"42173kedxifve0mh5q\",\"order\":1,\"title\":\"3nbp372dxizsx4s7u9mnl3e95\"},{\"articleId\":213,\"coverUrl\":\"yzj\",\"order\":2,\"title\":\"hlk\"},{\"articleId\":214,\"coverUrl\":\"d8om\",\"order\":3,\"title\":\"aybknxt62k\"},{\"articleId\":215,\"coverUrl\":\"vhij7q2tbhama4vbryx1lv0n2csq\",\"order\":4,\"title\":\"u9y01i5szy3\"}]",
	                "updateTime": 1487649204
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 44,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":323,\"coverUrl\":\"fpcs98mcdslyez8rv33gner7r\",\"order\":0,\"title\":\"np\"},{\"articleId\":208,\"coverUrl\":\"1ozoatfyrs7l8pq0zlnsyjrxfabs\",\"order\":1,\"title\":\"qg1bnocrxg7ha8787rnz\"},{\"articleId\":741,\"coverUrl\":\"m7e\",\"order\":2,\"title\":\"ann5h8\"},{\"articleId\":554,\"coverUrl\":\"09knvp5hap39258n482t48u\",\"order\":3,\"title\":\"ak898s2wxr6tfi6mc84gsbrpi\"},{\"articleId\":480,\"coverUrl\":\"bnrdcflsp9alr\",\"order\":4,\"title\":\"ps6nt4z6chxuhohwo9rgk6xpc\"}]",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 45,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":598,\"coverUrl\":\"zwoyl41qg3jl5u2vg8ewvugicy25a\",\"order\":0,\"title\":\"rd9c8b2is5i\"},{\"articleId\":726,\"coverUrl\":\"9aido6vwx2n79qv5\",\"order\":1,\"title\":\"j2v4x2\"},{\"articleId\":17,\"coverUrl\":\"\",\"order\":2,\"title\":\"btlwzwnvhpb\"},{\"articleId\":522,\"coverUrl\":\"171cp1b3147sd232tbfbhqb7r0h\",\"order\":3,\"title\":\"97prfjajwu4736ham\"},{\"articleId\":793,\"coverUrl\":\"psaoi39lnc8ghua20d7ae2ijc7\",\"order\":4,\"title\":\"yceaghyx0rwxh4\"}]",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 46,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":221,\"coverUrl\":\"se8jo7893olc7fqwsn\",\"order\":0,\"title\":\"c2dcqukkxnwb\"},{\"articleId\":941,\"coverUrl\":\"ut90xaoyiqr6r7l1oj9x87xpdnd\",\"order\":1,\"title\":\"1jk90swgzq7g43ds0iuimfl5wlz3\"},{\"articleId\":428,\"coverUrl\":\"bvv30n643bjwrdcr66oeiwd8\",\"order\":2,\"title\":\"yqcao3qlqlqvgj\"},{\"articleId\":550,\"coverUrl\":\"jam97yiexz1bj2i84utf\",\"order\":3,\"title\":\"w3rjgdmh67zh8o3xu6a41i0hp89g\"},{\"articleId\":5,\"coverUrl\":\"6kd5hznhg316ukjlhdsfvhci\",\"order\":4,\"title\":\"75b\"}]",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 47,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":507,\"coverUrl\":\"hpwfqtqfiixpvh\",\"order\":0,\"title\":\"3dk\"},{\"articleId\":797,\"coverUrl\":\"e4vbe\",\"order\":1,\"title\":\"6qtldbw6g2sg\"},{\"articleId\":273,\"coverUrl\":\"0l\",\"order\":2,\"title\":\"ygh8\"},{\"articleId\":578,\"coverUrl\":\"z7r9ev88owc3hcnp2r7di8mvbpc35\",\"order\":3,\"title\":\"h7mlh3w281q4htlqag9h84hr1\"},{\"articleId\":199,\"coverUrl\":\"1v2xrhbqletpmyamaz17a87\",\"order\":4,\"title\":\"\"}]",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 48,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":172,\"coverUrl\":\"8o5vqin5jl1jbahs7wau4h3fu0xdj\",\"order\":0,\"title\":\"djs5at21drx98i\"},{\"articleId\":980,\"coverUrl\":\"sd52wnmhf7fqbp839xroj80z1\",\"order\":1,\"title\":\"i1mro7wulvzgv8ezsoy9tg9\"},{\"articleId\":103,\"coverUrl\":\"cilazz0ewt\",\"order\":2,\"title\":\"1suo4x1ara060bdtih497tr79k31\"},{\"articleId\":434,\"coverUrl\":\"\",\"order\":3,\"title\":\"v\"},{\"articleId\":742,\"coverUrl\":\"7nzg9caszbm3j\",\"order\":4,\"title\":\"69ucjab8gnjjc3w5rn\"}]",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "createTime": 1487646169,
	                "id": 49,
	                "status": 0,
	                "status": 0,
	                "summary": "[{\"articleId\":892,\"coverUrl\":\"8r64an3nypcwsds9erpp34pbrp\",\"order\":0,\"title\":\"cjgtvlnlkfkwa\"},{\"articleId\":521,\"coverUrl\":\"a9c36sfo4iz\",\"order\":1,\"title\":\"pa2c\"},{\"articleId\":627,\"coverUrl\":\"bi1ctz1oxf6mjnc31gdk6lh\",\"order\":2,\"title\":\"8\"},{\"articleId\":574,\"coverUrl\":\"9f5t6x672\",\"order\":3,\"title\":\"yg5orvsnzgr1j3o\"},{\"articleId\":402,\"coverUrl\":\"u\",\"order\":4,\"title\":\"rexqwrrqmy8zhjv\"}]",
	                "updateTime": 1487646169
	            }
	        ],
	        "SingleAndAnnounceList": [
	            {
	                "accountId": 1,
	                "articleType": 0,
	                "author": "",
	                "backcontent": "",
	                "contentSourceUrl": "",
	                "coverUrl": "a04657x97hijcssnyd48ec",
	                "createTime": 1487646164,
	                "digest": "",
	                "html": "kysj6dcvths6c9rkgktzxtqs",
	                "id": 3,
	                "status": 0,
	                "showCoverPic": 1,
	                "status": 0,
	                "title": "0qe0m328ivl4jm4kp9iymp6f0",
	                "updateTime": 1487646164
	            },
	            {
	                "accountId": 1,
	                "articleType": 0,
	                "author": "",
	                "backcontent": "",
	                "contentSourceUrl": "",
	                "coverUrl": "7nzg9caszbm3j",
	                "createTime": 1487646169,
	                "digest": "",
	                "html": "fokwsn5wti6lfr",
	                "id": 240,
	                "status": 0,
	                "showCoverPic": 1,
	                "status": 0,
	                "title": "69ucjab8gnjjc3w5rn",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "articleType": 0,
	                "author": "",
	                "backcontent": "",
	                "contentSourceUrl": "",
	                "coverUrl": "8r64an3nypcwsds9erpp34pbrp",
	                "createTime": 1487646169,
	                "digest": "",
	                "html": "hwcaxckjvq1xs5aor7hho",
	                "id": 241,
	                "status": 0,
	                "showCoverPic": 1,
	                "status": 0,
	                "title": "cjgtvlnlkfkwa",
	                "updateTime": 1487646169
	            },
	            {
	                "accountId": 1,
	                "articleType": 0,
	                "author": "",
	                "backcontent": "",
	                "contentSourceUrl": "",
	                "coverUrl": "a9c36sfo4iz",
	                "createTime": 1487646169,
	                "digest": "",
	                "html": "3skyf6p9071p",
	                "id": 242,
	                "status": 0,
	                "showCoverPic": 1,
	                "status": 0,
	                "title": "pa2c",
	                "updateTime": 1487646169
	            }
	        ]
	    }
	}



## 文章搜索

### 接口

    String searchArticle(@ThriftField(value = 1, name = "uid") Long uid,
                         @ThriftField(value = 2, name = "groupIds") String groupIds,
                         @ThriftField(value = 3, name = "searchQueryBean") String searchQueryBean,
                         @ThriftField(value = 4, name = "keywordGroupIds") String keywordGroupIds,
                         @ThriftField(value = 5, name = "shouldKeywords") String shouldKeywords,
                         @ThriftField(value = 6, name = "mustKeywords") String mustKeywords,
                         @ThriftField(value = 7, name = "queryWay") Integer queryWay);
### 调用示例

    uid 管家用户ID  必输
	groupIds	监测组的id集合，与queryWay搭配
    searchQueryBean 
    {
    "endTime":1507878000,//与startTime 一起  可选输入
    "orderBy":"post_time_stamp",//orderType 一起  可选输入
    "orderType":"asc",
    "searchRangeList":[//必输其中一个或者两个
        "article_title",
        "article_body"
    ],
    "size":10,//start 一起  可选输入
    "start":0,
    "startTime":1504195200
    }

    keywordGroupIds   [1,2]  //关键字分组id数组 可选
    shouldKeywords    ["主人"]  //可选


    mustKeywords    ["主人"]  //可选

	queryWay	1 //查询方式：0，"查询全部公众号"；1，"查询特定分组的公众号"；2,"查询未进入监测组的公众号";


### 返回


    {
    "code":0,
    "data":{
        "boYueArticleList":[
            {
                "articleTitle":"北京已经开始下雪，在重庆御寒竟然会这样做……（文末有惊喜）",
                "gzhWxId":"chongqinghehaochi",
                "postTimeStamp":1507781768,
                "articleBody":"这么巧你也是吃货 那就戳重庆嘿好吃 好吃妹儿带你吃遍大重庆 好吃妹儿前几天看新闻， 说北京已经开始下雪 那么重庆呢 重庆天气也是一秒钟入秋 走在路上还可以看到有人穿着羽绒服 重庆御寒最直接有效的方法是什么 加衣服？带围巾？买热水器 不不不，这些都不是 在重庆最直接有效的一个方法 就是吃一顿让你血脉喷张的火锅 在重庆就有一家连续排队排了五年的网红火锅 好吃妹儿就带你去看看 搞|事|情 这家店的名字叫做潮火锅，一家连续排队五年的网红火锅店，真的是吃火锅一小时，排队五小时，不知道的人以为这家店在搞事情呢！其实这些人都是在这里排队吃火锅 以前好吃妹儿觉得出门吃火锅很容易，但是这次错了，这里排队真的太久啦！所以想吃到一道美食，过程也是十分艰辛的！想要吃到潮火锅，一定要做好排队的心里准备。 准吉尼斯纪录 一进去，我还以为这里是用普通木头搭建的！咦仔细一看，原来是筷子。这个是用十几万双筷子搭建的400平方米的火锅店！没有开玩笑，十几万双筷子！店里正在申请吉尼斯纪录了。 这家店的牛肉非比寻常 很多吃货，来这家店不为别的，就是想吃一回这里的潮椒牛肉。别人家的牛肉都是很小一片，潮火锅的牛肉真的是巴掌大，吃起来口感不知道比其他牛肉好到哪里去了。有的客人甚至一上来就点三四份，简直就是火锅界的爆款。据说潮火锅的老板不远万里才学到了潮椒牛肉的制作技术。 可以说，这道菜是必点的。不点毛肚鸭肠都要点这份潮椒牛肉。潮椒牛肉端上来的时候还冒着仙气，颜值十分的高，而且食材选用的是恒都牌牛霖肉，一头牛仅供十盘，涮着吃比毛肚更入味！ 潮椒牛肉实在太火，为了让喜爱它的客人吃到的始终是高品质牛肉，潮火锅决定开启限量模式，宁缺毋滥是老板一贯的坚持。吃的时候左右涮动40秒即可，吃起来刚刚好！食物的最高境界是什么，不仅要好看，而且又要好吃，潮椒牛肉它做到了。 除了潮椒牛肉店里没有什么好吃的了？那当然是不可能的。除了潮椒牛肉，还有很多特色菜。 现切牛肝 对于这道菜现切牛肝。我是惊讶了。牛肝如此之滑，如此之软的食物，被切成了这么薄的一片，这是要花多大的功夫呀。潮火锅为了保证菜品的新鲜程度，这里的大多数菜品都是现切的。 刚刚那张照片牛肝是铺在盘子里的，这张照片就可以看出牛肝是如此的薄，让好吃妹儿都想给厨师学学刀工了。当一片牛肝下到锅里，烫个十几秒，在捞上来，沾上一点香油，在嘴里咀嚼，你会情不自禁的说出来“耶，这个牛肝还霸道耶”。 小郡肝 小郡肝一个在成都火得不要不要的东西，在潮火锅吃到小郡肝好吃妹儿也是觉得太惊喜了。摆盘也是很卡哇伊，一个熊猫端着一个竹筒，竹筒里面装着用芊芊串起的小郡肝。触动了好吃妹儿的少女心，赶紧拍个照。 俗话说得好“小是小，威力好”。小郡肝的味道真的美味极了，我这个平时不吃这种内脏的人，吃的时候都是停不下来。重口味的朋友们，你们可以去挑战一下小郡肝沾干碟子的辣味，保证辣得爽呢。 生扣鸭肠 都知道“诸葛亮草船借箭吧”，但是草船送鸭肠估计你没有见过吧！当然，草船只是一个装扮，真正的精华是船上的鸭肠。潮火锅的鸭肠从取出到上桌，绝对不会超过12个小时。鸭肠，用筷子烫进锅里，烫至微微弯曲，约十几秒，过早未熟，过晚太老。潮火锅的鸭汤，烫好之后，第一感觉就是脆，第二感觉就是好吃。 店里除了这几个菜其它菜品都不好吃了吗？那也肯定就大错特错了，店里的其他菜也是很好吃的（好吃妹儿不仅仅是一个肉食动物）。 除了潮椒牛肉，腰片，小郡肝，腰片，毛肚鸭肠……这些荤菜之外这里的花生豆芽（花生豆芽好吃妹儿第一次见，比一般豆芽粗更有嚼劲），方竹笋，石磨豆腐，海带芽也是好吃极了。 寒冷的天气，想吃上一顿令你血脉喷张的火锅，那你就去潮火锅吧! 惊喜 对了你们可爱美丽善良的好吃妹儿 跟你们谋取了一份炒鸡 大大大大的福利 福利一 五份价值189元的霸王餐 （详情请见留言第一条） 福利二 这年头，长的瘦可以当钱花 潮火锅打算要养胖你们 带上你身边的瘦子朋友 低于120斤，菜品8.9折 低于100斤，菜品7.9折 到店凭图文称重 （截止时间即日起至10月31日） ps：这次福利仅限潮火锅金源店使用，且福利一、二不能同时享用， 似乎听到有人在说“好吃妹儿你还没有告诉我位置呢?”各位看官不要着急，我就大声的告诉你们这里在哪里？ 潮火锅 【人均】 70+ 【营业时间】 11:00-22:00 【地址】 观音桥金源大酒店楼下金源不夜城B1 （华谊兄弟电影院旁） 哪位小哥哥再带我去吃一次 撰稿：廖大聪聪 编辑：吃货小跟班 重庆嘿好吃原创编辑 转载请注明出处 商务合作请联系：156-8371-1370 历史推荐 △牛肉面中的LV！这一定是重庆逼格最高的面馆！一天只卖33碗！ △她们花了600万将这栋老宅还原，只为卖你一杯68元的鸡尾酒。 △一帮年龄加起来比这条街都大的老炮儿，在这里聊着比TFBoys还要新鲜的话题。 △她在解放碑中心卖了6年毛血旺，旁边是威斯汀、远东、星光…… △重庆小巷子里居然藏了50家神级馆子！有的连百度地图都搜不到！！你吃过几家？",
                "monitorGzhId":20,
                "articleId":"-8211152263249827000",
                "updateTime":1507781950,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MzA5OTM5OTQ2MQ==&mid=2652460491&idx=1&sn=67f494f5254afda5caa9bf88d99c3cb9",
                "gzhName":"重庆嘿好吃",
                "postTime":"2017-10-12 12:16:08",
                "gzhId":"-790385859964124374",
                "status":0,
                "createTime":1507781950,
                "id":2065,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"管你是谁，卖完打烊！这么牛牪犇的餐馆你见过吗？",
                "gzhWxId":"chizaicq",
                "postTimeStamp":1507788858,
                "articleBody":"重庆有不少“上了年纪”的社区，南岸福利社也算其中之一。四周都是低矮的居民楼，整条街都很安静，没什么人，看上去灰扑扑的。 但是越不起眼的地方，可能越是藏着一些令人意想不到的惊喜，比如这里就有☟ 拾级而上，居民楼的底层热闹非凡，小卖铺、理发店、按摩店……还有就是这家虽然没有招牌却不能让人忽视的小饭馆了。 店也就巴掌大，前台、厨房、饭厅通通都是这一间。坐里面两桌的客人也是能够真正的体验一把什么叫做“吃着自己碗里的，看着别人锅里的”。 由于店店真的太小了，但是中午来这里吃的客人又实在是多，老板连旁边的甬道也利用了起来。一张桌子，几个塑料板凳，再打开明晃晃的白炽灯，这样简陋的环境瞬间带领着食客穿越回了八十年代。 它家的菜是这样的！ 鸡汤 店名就叫小何鸡汤，所以头牌当然是鸡汤了。这里的鸡汤可是限量款，每天就卖那么几十罐，想去的时候就一定要记得提前打电话预订，不然来晚了，售完可无补呢！ 轻轻地搅拌一下，鸡汤上的油也不会散，不得不感叹一下这个土鸡真是好肥呀。喝之前有一点小小的担心怕会很油腻，不过入了口之后才发现完全是多虑了。在寒冷的天气里，喝上一口鲜味，全身上下都温暖了。 鸡肉被砍成小坨小坨的，肉质饱满鲜嫩，肉里面还带着一点点木耳的清香。小小的一盅里面，料给得很是实在，吃起来真是意犹未尽。 配菜 ▷凉拌肚条 打电话预订的时候，老板知道我们是第一次来吃，又是2人组，于是自行给我们配菜了。据说这家店的荤菜就只有几样，多年未变过，素菜就是店里炒什么，你就吃什么。 这道凉拌肚条也是店里很受喜爱。吃的时候一定要把佐料拌匀。肚条的嚼劲，葱苗的清香还有飘香的调料，确实很巴适。这个时候再来一碗沥米饭，就像在家吃饭那么惬意。 ▷回锅肉 回锅肉应该是很多人记忆里，最喜欢吃的一道妈妈做的菜吧。瘦肉连着肥肉，肉被大火炒至金黄。肥肉的部分爆得恰到好处，吃起来一点不干，剩下的那点油水又不会让人觉得很腻。 瘦肉的部分也是不差，肉质细腻，火候到位，吃起来焦香可口，配上红椒青椒，真的是下饭的必备神器。 ▷炒时蔬 老板这次给我们搭配的是茄子，浸满油之后茄子变得非常的绵软，单口吃的话会稍稍感觉有点油，所以这也是一道下饭的菜。 除此之外，还有麻辣爽脆的肝腰混合和鲜香可口的泡椒肉丝，虽然名字听起来都是平平的家常菜，但是饭桌上有了它们，胃口似乎也变得更好了一些。 离开的时候，陆陆续续还有人来，还有专门从很远的地方跑来打包的。不过，老板已经不！卖！了！吃姐看了看时间，12点才过半。只要材料一完，就再不接待。而且只有周一到周五的中午才开门，周末、节假日都要休息！尽管如此个性，买账的人还是不少。看来，老板坚持做“家的味道”，也是赚足了不少人心啊，毕竟在又苦又累的时候，能回“家”吃顿饭是多么幸福的事啊。 地址 主办方：微品数字传播 主编：陈卜文 | 副主编：江大雄 总监：林克勇 | 编辑：廖雅楠 本文由吃在重庆原创编辑，未经授权禁止转载",
                "monitorGzhId":9,
                "articleId":"1483128122093420727",
                "updateTime":1507789175,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5NzA2NTg2MQ==&mid=2652465954&idx=1&sn=377df1e4ee894e2ec21ad7963cdae909",
                "gzhName":"吃在重庆",
                "postTime":"2017-10-12 14:14:18",
                "gzhId":"-709717966422073348",
                "status":0,
                "createTime":1507789175,
                "id":2066,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"坚持吃这些“减脂草”，秋天也能瘦成一道闪电！",
                "gzhWxId":"chizaicq",
                "postTimeStamp":1507788858,
                "articleBody":"国庆嗨吃嗨喝超级开心 但是回来是不是发现自己的减肥大业又搁浅了 想着即将到来的冬天 自己将成为一个圆滚滚的球 是不是瞬间打了个寒颤 想要减肥赶紧戳下面的减脂餐get起来 果蔬沙拉拼盘 所需材料： 樱桃萝卜、苦菊、紫甘蓝、黄瓜（蔬菜） 玉米（粗粮） 猕猴桃、香蕉、圣女果（水果） 注：懒得不行就这么吃。 龙猫来了 所需材料： 全麦吐司、大米（细粮） 水煮秋葵、莴苣（蔬菜） 青苹果（水果） 注：少油盐糖。 虾仁芦笋炒面 所需食料： 炒鸡蛋、虾仁（蛋白） 芦笋、樱桃萝卜（蔬菜） 李子、圣女果（水果） 面（细粮） 黄桃rose 所需食料： 无油煎鸡胸肉（蛋白） 水绰芦笋（明星减脂蔬菜） 胡萝卜、生菜、西红柿（蔬菜） 注：黄桃rose切薄片卷。 蔬菜沙拉 所需食料： 水煮蛋（蛋白） 玉米粒（粗粮） 红椒、苦菊、紫甘蓝、胡萝卜（蔬菜） 秋刀鱼的滋味 所需材料： 秋刀鱼（蛋白） 香蕉（水果） 水绰秋葵，樱桃萝卜、番茄、生菜、苦菊、紫甘蓝、胡萝卜（蔬菜） 三文鱼蔬菜沙拉 所需材料： 无油煎三文鱼（蛋白） 水绰芦笋（明星减脂蔬菜） 苦菊、紫甘蓝（蔬菜） 注：配沙拉、油醋汁或其它自制酱。 猫和你都想了解的滋味 所需食材： 柠香秋刀鱼（蛋白） 水绰莴笋（明星减脂菜） 红椒（菌类蔬菜） 虾仁蔬菜沙拉 所需食材： 煎蛋、虾仁（蛋白） 玉米粒（粗粮） 水煮莴苣条、西红柿、紫甘蓝、苦菊（蔬菜） 想要冬天还瘦瘦的小伙伴 赶紧把这些减脂的“草”吃起来吧 主办方：微品数字传播 主编：陈卜文 | 副主编：江大雄 总监：林克勇 | 编辑：韦娅 注：本文综合整理于网络",
                "monitorGzhId":9,
                "articleId":"-2630586546756062554",
                "updateTime":1507789176,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5NzA2NTg2MQ==&mid=2652465954&idx=2&sn=6079767b14af935ce6ea6e29076bcccc",
                "gzhName":"吃在重庆",
                "postTime":"2017-10-12 14:14:18",
                "gzhId":"-709717966422073348",
                "status":0,
                "createTime":1507789176,
                "id":2067,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"<span style="color:red">主人</span>在上厕所，突然探出一只大橘头，吓得不轻啊~",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng 主人在上厕所 门口突然伸进一颗橘猫头 被萌拉稀了都... 喵：铲屎的，你屎吃完了吗 我等你好久啦！ 最后这张直接戳中萌点 一击毙命",
                "monitorGzhId":12,
                "articleId":"-4869549058771827055",
                "updateTime":1507790477,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=3&sn=84e17453d8ffeeb747066815f2f716a9",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790477,
                "highLight":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng <span style="color:red">主人</span>在上厕所 门口突然伸进一颗橘猫头 被萌拉稀了都... 喵：铲屎的，你屎吃完了吗 我等你好久啦！ 最后这张直接戳中萌点 一击毙命",
                "id":2070,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"没想到天不怕地不怕的大橘竟然怕打雷，可怜<span style="color:red">主人</span>了！",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng 这只大橘猫被打雷吓到了 本来反对养猫的爸爸 竟这么安抚着它，哈哈... 吓得像个两百斤的胖子 by/FB/SaiFa Cat : สายฟ้า",
                "monitorGzhId":12,
                "articleId":"109151842444693336",
                "updateTime":1507790477,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=6&sn=3e20d1e0eb47cfbb489766ec9bd11e1c",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790477,
                "id":2073,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"奶奶把泰迪当亲孙子一样的养着，好幸福~",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng 这位奶奶把泰迪当孙子养 每天都会用手撕肉给它吃，关心的无微不至 来吃这块，肉比较大 当肉拿过来时又担心太大泰迪不好嚼 就把肉撕成小块用汤匙喂给它吃 这样细心的奶奶让我看了都有点羡慕了 奶奶养大的狗真是太幸福了",
                "monitorGzhId":12,
                "articleId":"6749124259696936144",
                "updateTime":1507790478,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=7&sn=adb7a38a3430e244c8051892bcf6fe4b",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790478,
                "id":2074,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"重磅秘密曝光，端午可能是太阳的后裔~",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"此系列图文均来自微博@回忆专用小马甲， 关注萌宠微信（微信号：mengchongmeng）即可查看全部% 世上最好的减肥药是坏心情，所以能快快乐乐的胖着也是种幸运 你发现没，越长大越难不计得失，掏心掏肺的爱一个人 哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈老板你咋想的？？ 每天清晨，第一缕阳光照进，端午就赶过来了，迷迷糊糊的，不知道刚从哪儿睡醒，看谁都不顺眼。它先观察下四周，再找个阳光最充足的地方躺好，一会小呼噜就打上了，一上午就这点安排，很充实",
                "monitorGzhId":12,
                "articleId":"8581781771326508027",
                "updateTime":1507790476,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=1&sn=680b649802de64bb7c6b33fb95bd87b5",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790476,
                "id":2068,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"二哈，没想到你是这样的狗，<span style="color:red">主人</span>都快不行了你还踩两脚~",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng 二哈：我先踩两脚看看还有没有气！ 主人：.....滚下去！",
                "monitorGzhId":12,
                "articleId":"1787981035950965482",
                "updateTime":1507790477,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=2&sn=8cf9637b117b90639631fbc3507a5d05",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790477,
                "highLight":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng 二哈：我先踩两脚看看还有没有气！ <span style="color:red">主人</span>：.....滚下去！",
                "id":2069,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"如果家里有7只猫，那得有多幸福呀！",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng 饲主yoko家里有7只猫，每只都超级可爱，可以一天吸一只，简直不要太幸福啊！ 一天换一只吸，每天都有新鲜感！",
                "monitorGzhId":12,
                "articleId":"-3432078394331902438",
                "updateTime":1507790477,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=4&sn=35fc75478a3b78061b267dfab8c7bbaf",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790477,
                "id":2071,
                "refDate":"2017-10-12",
                "status":0
            },
            {
                "articleTitle":"网友收留一只流浪猫妈妈，没想到..............",
                "gzhWxId":"mengchongmeng",
                "postTimeStamp":1507790147,
                "articleBody":"更多精彩萌宠萌图欢迎关注【萌宠萌】微信微信号mengchongmeng FB网友Yee San在2015年的时候收留了一只怀孕的流浪猫麻麻... 没想到，这只黑乎乎的猫妈妈，生出来两只虎斑，还有两只雪白的小猫... 刚出生的时候是这样... 可是长大以后... 两只全白的不！见！了！ 虎斑变成了黑乎乎，全白变成了虎斑... 猫太多搞不清？我们拎出来再看一次... 雪白白的大姐和小弟... 长大后... by/FB/Yee San",
                "monitorGzhId":12,
                "articleId":"8721134553841940690",
                "updateTime":1507790477,
                "articleUrl":"http://mp.weixin.qq.com/s?__biz=MjM5MDI2MTAxMw==&mid=2653732952&idx=5&sn=00222996c182b9ad803db26c64f9dfd2",
                "gzhName":"萌宠萌",
                "postTime":"2017-10-12 14:35:47",
                "gzhId":"-5095068211913579959",
                "status":0,
                "createTime":1507790477,
                "id":2072,
                "refDate":"2017-10-12",
                "status":0
            }
        ],
        "total":114
    },
    "msg":"OK"
    }


## 获取重置密码二维码连接

### 接口

      String makeResetPasswordQrUrl();

### 调用示例




### 返回


    {"code":0,"data":{"www.baidu.com"},"msg":"Ok"}



## 获取用户绑定的账号列表

### 接口

      getUserManagedGzhAccountList(@ThriftField(value = 1, name = "openid") String openid,
                                               @ThriftField(value = 2, name = "page") String pageJson)
### 调用示例

     openid 必输
     pageJson  {}或者{"start":0,"size":10,"orderBy":"update_time","orderType":"DESC"}


### 返回


    {
    "code":0,
    "data":{
        "total":3,
        "accountList":[
            {
                "id":1134,
                "username":"微政云开发"
            },
            {
                "id":1244,
                "username":"微虎队"
            },
            {
                "id":1326,
                "username":"微政云测试"
            }
        ]
    },
    "msg":"Ok"
    }



## 重置登录密码

### 接口

      resetAccountPassword(@ThriftField(value = 1, name = "openid") String openid,
                                       @ThriftField(value = 2, name = "uid") Long uid)

### 调用示例

    openid 必输
    uid 上一步获取列表中的id

### 返回


    {"code":0,"data":{},"msg":"Ok"}	




## 批量新增关键字分组

### 接口

    String addAccountKeywordGroups(@ThriftField(value = 1, name = "uid") Long uid,
                                   @ThriftField(value = 2, name = "groupNames") String groupNames);

### 调用示例

    uid 1132 管家用户ID  必输

    keywords ["牛逼","真牛逼"] 必输


### 返回


    {
    "code":0,
    "data":[
        {
            "accountId":1132,
            "createTime":1508828836,
            "groupName":"分组1",
            "id":3,
            "status":0,
            "keywordCnt":0,
            "updateTime":1508828836
        },
        {
            "accountId":1132,
            "createTime":1508828836,
            "groupName":"分组2",
            "id":4,
            "status":0,
            "keywordCnt":0,
            "updateTime":1508828836
        }
    ],
    "msg":"OK"
    }


## 修改关键字分组

### 接口

    String updateAccountKeywordGroup(@ThriftField(value = 1, name = "uid") Long uid,
                                     @ThriftField(value = 2, name = "groupId") Long groupId,
                                     @ThriftField(value = 3, name = "groupName") String groupName);

### 调用示例

    uid 1132 管家用户ID  必输

    groupId 2

    groupName 哇哈哈



### 返回


    {"code":0,"data":{},"msg":"Ok"}




## 批量删除关键字分组

### 接口

    String batchDeleteAccountKeywordGroups(@ThriftField(value = 1, name = "uid") Long uid,
                                           @ThriftField(value = 2, name = "groupNameIds") String groupNameIds);

### 调用示例

    uid 1132 管家用户ID  必输

    ids [1,2]



### 返回


    {"code":0,"data":{},"msg":"Ok"}



## 获取关键字分组列表

### 接口

      String getAccountKeywordGroupList(@ThriftField(value = 1, name = "uid") Long uid,
                                      @ThriftField(value = 2, name = "pageJson") String pageJson);

### 调用示例

    uid 1132 管家用户ID  必输

    pageJson  {}或者{"start":0,"size":10,"orderBy":"update_time","orderType":"DESC"}



### 返回


    {
    "code":0,
    "data":{
        "total":2,
        "accountKeywordGroupList":[
            {
                "accountId":1132,
                "createTime":1508828836,
                "groupName":"分组1",
                "id":3,
                "status":0,
                "keywordCnt":0,
                "updateTime":1508828836
            }
        ]
    },
    "msg":"OK"
    }



## 批量新增关键字

### 接口

    String addAccountKeywords(@ThriftField(value = 1, name = "uid") Long uid,
                                     @ThriftField(value = 2, name = "groupId") Long groupId,
                                     @ThriftField(value = 3, name = "keywords") String keywords)

### 调用示例

    uid 1132 管家用户ID  必输

    groupId3

    keywords ["牛逼","真牛逼"] 必输


### 返回


    {
    "code":0,
    "data":[
        {
            "accountId":1132,
            "createTime":1508829797,
            "groupId":3,
            "groupName":"分组1",
            "id":3,
            "status":0,
            "keyword":"牛逼",
            "updateTime":1508829797
        },
        {
            "accountId":1132,
            "createTime":1508829797,
            "groupId":3,
            "groupName":"分组1",
            "id":4,
            "status":0,
            "keyword":"真牛逼",
            "updateTime":1508829797
        }
    ],
    "msg":"OK"
    }


## 批量导入关键字词组

### 接口

    String batchAddAccountKeywords(@ThriftField(value = 1, name = "uid") Long uid,
                                     @ThriftField(value = 2, name = "saveRule") Integer saveRule,
                                     @ThriftField(value = 3, name = "keywords") String keywords)

### 调用示例

    uid 1132 管家用户ID  必输

    saveRule  0//重命名 1//覆盖

    keywords 
    [
    {
        "groupName":"分组1",
        "keywordList":[
            "啊哈哈",
            "哇哈哈"
        ]
    }
    ]


### 返回


    {
    "code":0,
    "data":{
        "successSaveGroupList":[
            "分组1"
        ],
        "failSaveGroupList":[

        ]
    },
    "msg":"OK"
    }

## 更新关键字

### 接口

    String updateAccountKeyword(@ThriftField(value = 1, name = "uid") Long uid,
                                @ThriftField(value = 2, name = "groupId") Long groupId,
                                @ThriftField(value = 3, name = "id") Long id,
                                @ThriftField(value = 4, name = "keyword") String keyword);

### 调用示例

    uid 1132 管家用户ID  必输

    groupId 3

    id 3

    keyword 哈哈哈



### 返回


    {"code":0,"data":{},"msg":"Ok"}




## 批量删除关键字

### 接口

    String batchDeleteAccountKeywords(@ThriftField(value = 1, name = "uid") Long uid,
                                      @ThriftField(value = 2, name = "groupId") Long groupId,
                                      @ThriftField(value = 3, name = "ids") String ids);

### 调用示例

    uid 1132 管家用户ID  必输

    groupId 3

    ids [1,2]



### 返回


    {"code":0,"data":{},"msg":"Ok"}



## 获取关键字列表

### 接口

      String getAccountKeywordList(@ThriftField(value = 1, name = "uid") Long uid,
                                 @ThriftField(value = 2, name = "groupId") Long groupId,
                                 @ThriftField(value = 3, name = "pageJson") String pageJson);

### 调用示例

    uid 1132 管家用户ID  必输

    groupId 3

    pageJson  {}或者{"start":0,"size":10,"orderBy":"update_time","orderType":"DESC"}



### 返回


    {
    "code":0,
    "data":{
        "total":1,
        "accountKeywordList":[
            {
                "accountId":1132,
                "createTime":1508829797,
                "groupId":3,
                "groupName":"分组1",
                "id":4,
                "status":0,
                "keyword":"真牛逼",
                "updateTime":1508829797
            }
        ]
    },
    "msg":"OK"
    }


## 通过管家id获取旗下的所有分组信息

### 接口

    String getMonitorGroupsByAccountId(@ThriftField(value = 1, name = "uid") Long uid);

### 调用示例

* uid 管家id

		1133L 

		
### 返回
	
	{
		"code":0,
		"data":{
		    "monitorGroups":[
		        {
		            "createTime":1511770436,
		            "id":176,
		            "status":1,
		            "managerId":1133,
		            "name":"你好",
		            "platform":0,
		            "updateTime":1511770436
		        },
		        {
		            "createTime":1511770871,
		            "id":177,
		            "status":1,
		            "managerId":1133,
		            "name":"fgbc",
		            "platform":0,
		            "updateTime":1511770871
		        },
		        {
		            "createTime":1511770875,
		            "id":178,
		            "status":1,
		            "managerId":1133,
		            "name":"drth",
		            "platform":0,
		            "updateTime":1511770875
		        }
		    ]
		},
		"msg":"OK"
	}

## 特定条件查询公众号

### 接口

    String getMonitorGzhsByConditions(@ThriftField(value = 1, name = "uid") Long uid,
                                      @ThriftField(value = 2, name = "page") String pageJson,
                                      @ThriftField(value = 3, name = "groupId") Long groupId,
                                      @ThriftField(value = 4, name = "queryWay")Integer queryWay);


### 调用示例

	* uid 1133L //管家id
	* page //分页
	
			{
			    "keyword":"",
			    "orderBy":"id",
			    "orderType":"desc",
			    "size":10,
			    "start":0
			}
	* groupId 222l//监测组id
	
			 
	* queryWay	1//	查询方式：0，"查询全部公众号"；1，"查询特定分组的公众号"；2,"查询未进入监测组的公众号";
	
			
		
### 返回
	
	{
    "code":0,
    "data":{
        "count":26,
        "monitorGzhs":[
            {
                "gzhName":"温江经信",
                "id":31,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"巫溪网",
                "id":30,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"长寿圈",
                "id":29,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"大足人家",
                "id":28,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"重庆城",
                "id":27,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"重庆崽儿",
                "id":26,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"重庆微生活",
                "id":25,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"奉节生活网",
                "id":24,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"江津在线",
                "id":23,
                "monitorGroups":[

                ]
            },
            {
                "gzhName":"忠县之家",
                "id":22,
                "monitorGroups":[

                ]
            }
        ]
    },
    "msg":"OK"
	}





## 通过条件查询监测组信息

### 接口

    String getMonitorGroupsByConditions(@ThriftField(value = 1, name = "uid") Long uid,
                                        @ThriftField(value = 2, name = "page") String pageJson);



### 调用示例

	* uid 1133L //管家id
	* page //分页
	
			{
			    "keyword":"",
			    "orderBy":"id",
			    "orderType":"desc",
			    "size":10,
			    "start":0
			}
	
### 返回
	
	{
    "code":0,
    "data":{
        "count":23,
        "groups":[
            {
                "id":246,
                "monitorGzhNum":0,
                "name":"aaaA",
                "platform":0
            },
            {
                "id":245,
                "monitorGzhNum":9,
                "name":"AAAa",
                "platform":0
            },
            {
                "id":244,
                "monitorGzhNum":4,
                "name":"aaaa",
                "platform":0
            },
            {
                "id":243,
                "monitorGzhNum":2,
                "name":"AAAA",
                "platform":0
            },
            {
                "id":242,
                "monitorGzhNum":2,
                "name":"测试长哈",
                "platform":0
            },
            {
                "id":241,
                "monitorGzhNum":4,
                "name":"西游记外传",
                "platform":0
            },
            {
                "id":240,
                "monitorGzhNum":0,
                "name":"西游记",
                "platform":0
            },
            {
                "id":239,
                "monitorGzhNum":0,
                "name":"红骷髅梦",
                "platform":0
            },
            {
                "id":238,
                "monitorGzhNum":0,
                "name":"三国演义",
                "platform":0
            },
            {
                "id":237,
                "monitorGzhNum":0,
                "name":"水浒传",
                "platform":0
            }
        ]
    },
    "msg":"OK"
	}




## 根据groupId删除监测分组

### 接口

	String deleteMonitorGroupByGroupId(@ThriftField(value = 1, name = "uid")Long uid,
                                       @ThriftField(value = 2, name = "groupId")Long groupId);



### 调用示例

	* uid 1133L //管家id
	* groupId 222l//待删除的监测组的id
	
			
	
### 返回
	{"code":0,"data":{},"msg":"OK"}


## 通过groupId更新监测分组信息

### 接口

	String updateMonitorGroup(@ThriftField(value = 1, name = "uid")Long uid,
                              @ThriftField(value = 2, name = "groupId")Long groupId,
                              @ThriftField(value = 3, name = "name")String name,
                              @ThriftField(value = 4, name = "platform")Integer platform);


### 调用示例

	* uid 1133L //管家id
	* groupId 232l//监测组的id
	* name	"abc"//监测组新name
	* platform	1//平台
	
			
	
### 返回
	{"code":0,"data":{},"msg":"OK"}




## 通过管家id获取旗下的所有公众号

### 接口

	String getGzhsByAccountId(@ThriftField(value = 1, name = "uid")Long uid);


### 调用示例

	* uid 1133L //管家id
	
	
			
	
### 返回
	{
    "code":0,
    "data":{
        "gzhs":[
            {
                "gzhName":"莽哥来了",
                "id":3
            },
            {
                "gzhName":"重庆早8点",
                "id":4
            },
            {
                "gzhName":"爱上大重庆",
                "id":5
            },
            {
                "gzhName":"吃在重庆",
                "id":9
            },
            {
                "gzhName":"重庆潮生活",
                "id":10
            },
            {
                "gzhName":"萌宠",
                "id":11
            },
            {
                "gzhName":"萌宠萌",
                "id":12
            },
            {
                "gzhName":"我和重庆",
                "id":13
            },
            {
                "gzhName":"万州生活",
                "id":14
            },
            {
                "gzhName":"秀山在线",
                "id":15
            },
            {
                "gzhName":"巴适重庆",
                "id":16
            },
            {
                "gzhName":"涪陵在线",
                "id":17
            },
            {
                "gzhName":"茶竹永川网",
                "id":18
            },
            {
                "gzhName":"重庆攻略",
                "id":19
            },
            {
                "gzhName":"重庆嘿好吃",
                "id":20
            },
            {
                "gzhName":"我爱重庆",
                "id":21
            },
            {
                "gzhName":"忠县之家",
                "id":22
            },
            {
                "gzhName":"江津在线",
                "id":23
            },
            {
                "gzhName":"奉节生活网",
                "id":24
            },
            {
                "gzhName":"重庆微生活",
                "id":25
            },
            {
                "gzhName":"重庆崽儿",
                "id":26
            },
            {
                "gzhName":"重庆城",
                "id":27
            },
            {
                "gzhName":"大足人家",
                "id":28
            },
            {
                "gzhName":"长寿圈",
                "id":29
            },
            {
                "gzhName":"巫溪网",
                "id":30
            },
            {
                "gzhName":"温江经信",
                "id":31
            }
        ]
    },
    "msg":"OK"
	}



## 通过分组id获取旗下的所有公众号

### 接口

	String getGzhsByGroupId(@ThriftField(value = 1, name = "uid")Long uid,
                            @ThriftField(value = 2, name = "groupId")Long groupId);


### 调用示例

	* uid 1133L //管家id
	* groupId 232l//监测组id
	
	
			
	
### 返回
	{"code":0,"data":{"gzhs":[]},"msg":"OK"}


## 通过管家id和监测组的name,platform等信息新建检测组

### 接口

	String addMonitorGroup(@ThriftField(value = 1, name = "uid")Long uid,
                           @ThriftField(value = 2, name = "groupName")String groupName,
                           @ThriftField(value = 3, name = "platform")Integer platform);


### 调用示例

	* uid 1133L //管家id
	* groupName "www.baidu.com"//监测组的name	
	* platform 1//平台
	
	
			
	
### 返回
	{
    "code":0,
    "data":{
        "monitorGroup":{
            "createTime":1511949180,
            "id":247,
            "status":0,
            "managerId":1133,
            "name":"www.baidu.com",
            "platform":0,
            "updateTime":1511949180
        }
    },
    "msg":"OK"
	}

## 更新某个监测组下所属的公众号
### 接口

	String updateGzhMonitorGroupRealation(@ThriftField(value = 1, name = "uid")Long uid,
                                          @ThriftField(value = 2, name = "groupId")Long groupId,
                                          @ThriftField(value = 3, name = "gzhIds")String gzhIds);


### 调用示例

	* uid 1133L //管家id
	* groupId 232l//监测组id
	* gzhIds //公众号的数组
	[17,18]
			
	
### 返回
	{"code":0,"data":{},"msg":"OK"}