# mini-shop-api

## Table of Contents

-  [Introduction](#introduction)

-  [Technology](#Technology)

-  [Insomnia Collection](#Collection)
  
-  [Database design](#Database) 

---

## Introduction


<p>Mini shop api is small app for manage your small shop business</p>

  

## Technology


- Java

- Spring Boot

- Hibernate

- JPA

- MySQL

- Jakarta Validation

  

## Insomnia Collection


[mini-shop-Insomnia_2024-04-01.json](https://github.com/szatrio/mini-shop-api/files/14820631/mini-shop-Insomnia_2024-04-01.json)
{"_type":"export","__export_format":4,"__export_date":"2024-04-01T07:08:01.604Z","__export_source":"insomnia.desktop.app:v8.6.1","resources":[{"_id":"req_47f5543362a54ee691a270c2c43e6ffc","parentId":"fld_3d599de051524190bf1e8301865d8832","modified":1711955099247,"created":1711950450331,"url":"http://localhost:8080/api/orders","name":"Place Order","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"customerId\":\"facef928-8a8c-412f-bb6c-aeef4869fd62\",\n\t\"cartProductIdList\":[\n\t\t\"47034beb-ef1f-48dc-b403-1157b086b9f5\",\n\t\t\"a325ddac-a2f5-4664-8571-3cf22af418b2\"\n\t]\n\t\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711950450331,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"fld_3d599de051524190bf1e8301865d8832","parentId":"wrk_3aec43b2910740af9a713ae5af9fd862","modified":1711950429594,"created":1711950429594,"name":"Cart","description":"","environment":{},"environmentPropertyOrder":null,"metaSortKey":-1711950429594,"_type":"request_group"},{"_id":"wrk_3aec43b2910740af9a713ae5af9fd862","parentId":null,"modified":1711903392131,"created":1711903392131,"name":"mini shop","description":"","scope":"collection","_type":"workspace"},{"_id":"req_0a0b063c661741daa9f962eaa4dc797d","parentId":"fld_3d599de051524190bf1e8301865d8832","modified":1711955126990,"created":1711950440741,"url":"http://localhost:8080/api/carts","name":"Add to Cart","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"customerId\":\"facef928-8a8c-412f-bb6c-aeef4869fd62\",\n\t\"productId\":\"c849afe5-6b7b-4e64-b56a-e85c2f2172a8\",\n\t\"qty\":3\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711950446951,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_b2b922f233fa4e909988db1636d9fd9f","parentId":"fld_b8efe01329944f78bcc382761c7d97fc","modified":1711917655108,"created":1711908120600,"url":"http://localhost:8080/api/customers/88535f24-ab32-45cd-b3d3-5cc85f7b2fc4","name":"Update","description":"","method":"PUT","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Mukhlas\",\n\t\"address\": \"Jalan Semen Kota Maninjau\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029768,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"fld_b8efe01329944f78bcc382761c7d97fc","parentId":"wrk_3aec43b2910740af9a713ae5af9fd862","modified":1711914018755,"created":1711913991952,"name":"Customer","description":"","environment":{},"environmentPropertyOrder":null,"metaSortKey":-1711913992152,"_type":"request_group"},{"_id":"req_49a0f6ecfb2b4f10946bf62b1826d0ab","parentId":"fld_b8efe01329944f78bcc382761c7d97fc","modified":1711917659038,"created":1711910065605,"url":"http://localhost:8080/api/customers","name":"Get List","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029668,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_fe60d004ca584382b370334775297c2a","parentId":"fld_b8efe01329944f78bcc382761c7d97fc","modified":1711917662667,"created":1711909399641,"url":"http://localhost:8080/api/customers/88535f24-ab32-45cd-b3d3-5cc85f7b2fc4","name":"Get","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029568,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_066005d46cfb42c4ad95c059918bd738","parentId":"fld_b8efe01329944f78bcc382761c7d97fc","modified":1711917666460,"created":1711903398041,"url":"http://localhost:8080/api/customers","name":"Create","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Mukhlis\",\n\t\"address\": \"Jalan Semen Kota Maninjau\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029468,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_402b593210084c21b4b199149c184b7a","parentId":"fld_1b6cd1b6c52347f28fedfaa577f31eb2","modified":1711927974711,"created":1711917578525,"url":"http://localhost:8080/api/product-types","name":"Create","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Furnitur\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029868,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"fld_1b6cd1b6c52347f28fedfaa577f31eb2","parentId":"wrk_3aec43b2910740af9a713ae5af9fd862","modified":1711917578521,"created":1711917578521,"name":"Product Type","description":"","environment":{},"environmentPropertyOrder":null,"metaSortKey":-1711913992102,"_type":"request_group"},{"_id":"req_b741f0bd2122451690be600155c92380","parentId":"fld_1b6cd1b6c52347f28fedfaa577f31eb2","modified":1711917970932,"created":1711917578538,"url":"http://localhost:8080/api/product-types/85db7d49-a45b-458d-ae9d-1ac8a54e1bc2","name":"Get","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029843,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_b44a01f01dfa4bc7a2aa98f85e663106","parentId":"fld_1b6cd1b6c52347f28fedfaa577f31eb2","modified":1711917958079,"created":1711917578548,"url":"http://localhost:8080/api/product-types","name":"Get List","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029818,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_8744f0a965fc44e29c3416d33c0c6675","parentId":"fld_1b6cd1b6c52347f28fedfaa577f31eb2","modified":1711917995730,"created":1711917578529,"url":"http://localhost:8080/api/product-types/85db7d49-a45b-458d-ae9d-1ac8a54e1bc2","name":"Update ","description":"","method":"PUT","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Elektronik\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029768,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_f61034a6f2bc4662a0cb45b3060be5a9","parentId":"fld_bfb2fd0705034266989eda2b500dc753","modified":1711929493959,"created":1711927997152,"url":"http://localhost:8080/api/products","name":"Create","description":"","method":"POST","body":{"mimeType":"application/json","text":"{\n\t\"name\": \"Lemari Besar\",\n\t\"price\": 3000000,\n\t\"productTypeId\": \"23747ef2-875a-4836-bbe4-d35563b5d707\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029868,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"fld_bfb2fd0705034266989eda2b500dc753","parentId":"wrk_3aec43b2910740af9a713ae5af9fd862","modified":1711927997150,"created":1711927997150,"name":"Product","description":"","environment":{},"environmentPropertyOrder":null,"metaSortKey":-1711913992052,"_type":"request_group"},{"_id":"req_e716336fd4074b78b059cedfb22286b5","parentId":"fld_bfb2fd0705034266989eda2b500dc753","modified":1711933500760,"created":1711927997155,"url":"http://localhost:8080/api/products/196da6d5-d2ba-4e4b-a036-54fa28409f1c","name":"Get","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029843,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_88b69c5e650247e593da636a268e436a","parentId":"fld_bfb2fd0705034266989eda2b500dc753","modified":1711933710408,"created":1711927997156,"url":"http://localhost:8080/api/products?page=1&limit=5","name":"Get List","description":"","method":"GET","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029818,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_6fd86fdd5d3f40bca8b9521254885bf7","parentId":"fld_bfb2fd0705034266989eda2b500dc753","modified":1711934072297,"created":1711927997154,"url":"http://localhost:8080/api/products/96527652-3af9-4939-b224-b74fc82b9d08","name":"Update ","description":"","method":"PUT","body":{"mimeType":"application/json","text":"{\n\t\t\"name\": \"Buffet Kayu\",\n\t\t\"price\": 27000000,\n\t\t\"productTypeId\": \"85db7d49-a45b-458d-ae9d-1ac8a54e1bc2\"\n}"},"parameters":[],"headers":[{"name":"Content-Type","value":"application/json"},{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029768,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"req_185bc36c45f8470fa7411cc3ede6e7e7","parentId":"fld_bfb2fd0705034266989eda2b500dc753","modified":1711930143447,"created":1711929818062,"url":"http://localhost:8080/api/products/009d448e-8c84-452b-80b4-d202ca2dcb2b","name":"Delete","description":"","method":"DELETE","body":{},"parameters":[],"headers":[{"name":"User-Agent","value":"insomnia/8.6.1"}],"authentication":{},"metaSortKey":-1711914029668,"isPrivate":false,"pathParameters":[],"settingStoreCookies":true,"settingSendCookies":true,"settingDisableRenderRequestBody":false,"settingEncodeUrl":true,"settingRebuildPath":true,"settingFollowRedirects":"global","_type":"request"},{"_id":"env_f7eab38622b4d3406cfec56b6a8120d31f299405","parentId":"wrk_3aec43b2910740af9a713ae5af9fd862","modified":1711903392134,"created":1711903392134,"name":"Base Environment","data":{},"dataPropertyOrder":null,"color":null,"isPrivate":false,"metaSortKey":1711903392134,"_type":"environment"},{"_id":"jar_f7eab38622b4d3406cfec56b6a8120d31f299405","parentId":"wrk_3aec43b2910740af9a713ae5af9fd862","modified":1711903392136,"created":1711903392136,"name":"Default Jar","cookies":[],"_type":"cookie_jar"}]}

----


## Database

![image](https://github.com/szatrio/mini-shop-api/assets/31741060/4e0a4e93-9412-4708-8ae3-6b4881850876)



  

License

----

  

© Satrio Utomo
