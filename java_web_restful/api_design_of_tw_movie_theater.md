# 思沃影院 API

| 说明                           | URL                    | method | 状态码 | 返回数据                                                     |
| ------------------------------ | ---------------------- | ------ | ------ | ------------------------------------------------------------ |
| 获取电影详情                   | `/movies/details?id=`  | GET    | 200    | `{"id": "1291545", "title": "大鱼", "directors": "蒂姆·波顿", "casts": ["伊万·麦克格雷格", "阿尔伯特·芬尼"], "genres": ["剧情", "家庭"], "image"："", "original_title": "Big Fish", "rating": "8.7", "year": "2003", "countries": ["美国"]}` |
| 获取电影详情                   | `/movies/?id=`         | GET    | 404    | `{"error": "Movie does not exist"}`                          |
| 获取详情中包含特定关键字的电影 | `/movies/search?key=`  | GET    | 200    | `{"id": ["1291545", "1292213"]}`                             |
| 获取某一类型的电影             | `/movies/?genres=`     | GET    | 200    | `{"id": ["1291545", "1292213"]}`                             |
| 获取电影短评                   | `/comments/?movie_id=` | GET    | 200    | `{"count": "20", "comments": [{"rating": "4.0", "author": "zhangsan", "movie_id": "1291545", "create_at": "2007-02-09", "content": "..."}, {"rating": "5.0", "author": "lisi", "movie_id": "1291545", "create_at": "2007-06-23", "content": "..."}]}` |
| 获取电影短评                   | `/comments/?movie_id=` | GET    | 404    | `{"error": "Movie does not exist"}`                          |
| 获取电影影评                   | `/reviews/?movie_id=`  | GET    | 200    | `{"count": "5", "reviews": [{"rating": "4.0", "author": "zhangsan", "movie_id": "1291545", "create_at": "2007-02-09", "content": "..."}, {"rating": "5.0", "author": "lisi", "movie_id": "1291545", "create_at": "2007-06-23", "content": "..."}]}` |
| 获取电影影评                   | `/reviews/?movie_id=`  | GET    | 404    | `{"error": "Movie does not exist"}`                          |

