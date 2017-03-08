package com.nov.openview.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yangzhicong on 2017/2/20.
 */

public class EssayListBean implements Serializable{

    /**
     * count : 0
     * posts : [{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 22:00:00","original_url":"","url":"https://moment.douban.com/post/144624/?douban_rec=1","short_url":"https://dou.bz/1QawCH","is_liked":false,"column":"洗洗睡","app_css":7,"abstract":"无论我们如何地热衷于在碎玻璃上跳舞，总有些门不该被打开，总有些故事刺痛喉咙像烧着烧着就熄灭了的火，心碎的人并不畏惧人群\u2026\u2026","date":"2016-08-11","like_count":324,"comments_count":53,"thumbs":[{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118439.jpg","width":460,"height":689},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118439.jpg","width":460,"height":689},"tag_name":"img_1","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118439.jpg","width":320,"height":479},"id":118439}],"created_time":"2016-08-11 14:26:26","title":"洗洗睡｜事物的关联令人心碎","share_pic_url":"https://moment.douban.com/share_pic/post/144624.jpg","type":"1001","id":144624},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 21:00:00","original_url":"https://www.douban.com/note/569541854/","url":"https://moment.douban.com/post/142683/?douban_rec=1","short_url":"https://dou.bz/21jhi2","is_liked":false,"author":{"is_followed":false,"editor_notes":"写画撰稿人，凡间食习生。","uid":"sayblack","resume":"奔赴在野路子上，写几篇小文，绘霹雳葫芦，画一点小画。","url":"https://www.douban.com/people/sayblack/","avatar":"https://img3.doubanio.com/icon/u1500312-44.jpg","name":"大霹雳","is_special_user":false,"last_post_time":"2017-02-03 00:00:00","n_posts":35,"alt":"为这宇宙之广漠而终有孤胆。","large_avatar":"https://img3.doubanio.com/icon/up1500312-44.jpg","id":"1500312","is_auth_author":true},"column":"","app_css":7,"abstract":"理发的阿姨不必像农户那样，扎着头巾藏起面庞，满身尘土去地里干活，而是化着精心的妆容，熟练地帮人做发型，再用饰品装饰起来。","date":"2016-08-11","like_count":71,"comments_count":5,"thumbs":[{"medium":{"url":"https://img5.doubanio.com/view/presto/medium/public/t117686.jpg","width":600,"height":837},"description":"","large":{"url":"https://img5.doubanio.com/view/presto/large/public/t117686.jpg","width":600,"height":837},"tag_name":"img_1","small":{"url":"https://img5.doubanio.com/view/presto/small/public/t117686.jpg","width":320,"height":446},"id":117686}],"created_time":"2016-07-11 11:10:06","title":"爸妈的生活怀想录：理发","share_pic_url":"https://moment.douban.com/share_pic/post/142683.jpg","type":"1001","id":142683},{"display_style":10003,"is_editor_choice":false,"published_time":"2016-08-11 19:00:00","original_url":"https://www.douban.com/photos/album/78809368/","url":"https://moment.douban.com/post/141933/?douban_rec=1","short_url":"https://dou.bz/1zf7Zm","is_liked":false,"author":{"is_followed":false,"uid":"unarcenciel","url":"https://www.douban.com/people/unarcenciel/","avatar":"https://img1.doubanio.com/icon/u4810525-89.jpg","name":"Pearciac","is_special_user":false,"n_posts":0,"alt":"Ich gehör nur mir","large_avatar":"https://img1.doubanio.com/icon/up4810525-89.jpg","id":"4810525","is_auth_author":false},"column":"去远方","app_css":7,"abstract":"法国不只是巴黎，还有阳光、海岸与古堡。","date":"2016-08-11","like_count":454,"comments_count":15,"thumbs":[{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118325.jpg","width":960,"height":540},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118325.jpg","width":1600,"height":901},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118325.jpg","width":320,"height":180},"id":118325},{"medium":{"url":"https://img5.doubanio.com/view/presto/medium/public/t118326.jpg","width":960,"height":596},"description":"","large":{"url":"https://img5.doubanio.com/view/presto/large/public/t118326.jpg","width":1600,"height":994},"tag_name":"img_2","small":{"url":"https://img5.doubanio.com/view/presto/small/public/t118326.jpg","width":320,"height":198},"id":118326},{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118327.jpg","width":600,"height":450},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118327.jpg","width":600,"height":450},"tag_name":"img_3","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118327.jpg","width":320,"height":240},"id":118327}],"created_time":"2016-06-27 10:27:02","title":"法国不只是巴黎","share_pic_url":"https://moment.douban.com/share_pic/post/141933.jpg","type":"1004","id":141933},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 17:00:00","original_url":"https://www.douban.com/note/567787616/","url":"https://moment.douban.com/post/142366/?douban_rec=1","short_url":"https://dou.bz/3CJg2w","is_liked":false,"author":{"is_followed":false,"uid":"along","url":"https://www.douban.com/people/along/","avatar":"https://img1.doubanio.com/icon/u1056861-659.jpg","name":"安蓝·怪伯爵","is_special_user":false,"n_posts":0,"alt":"BUT！人生最厉害就是这个BUT！","large_avatar":"https://img1.doubanio.com/icon/up1056861-659.jpg","id":"1056861","is_auth_author":false},"column":"去远方","app_css":7,"abstract":"云压得更低了，于是变成特别有种寂寥感觉的海岸，停下来吹了吹海风。关于绿岛，我的第一反应是监狱，但其实那很美。","date":"2016-08-11","like_count":170,"comments_count":4,"thumbs":[{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118308.jpg","width":600,"height":400},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118308.jpg","width":600,"height":400},"tag_name":"img_2","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118308.jpg","width":320,"height":213},"id":118308}],"created_time":"2016-07-04 16:29:08","title":"多图｜坐船去绿岛","share_pic_url":"https://moment.douban.com/share_pic/post/142366.jpg","type":"1001","id":142366},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 16:00:00","original_url":"https://www.douban.com/note/575020163/","url":"https://moment.douban.com/post/144460/?douban_rec=1","short_url":"https://dou.bz/2qvZF3","is_liked":false,"author":{"is_followed":false,"uid":"130357068","url":"https://www.douban.com/people/130357068/","avatar":"https://img3.doubanio.com/icon/u130357068-5.jpg","name":"Smart Chic","is_special_user":false,"n_posts":0,"alt":"常来玩 :)","large_avatar":"https://img3.doubanio.com/icon/up130357068-5.jpg","id":"130357068","is_auth_author":false},"column":"爱美丽","app_css":7,"abstract":"这样的配色在夜里还是挺明亮醒目的。至于版式、细节设计就真的难称上乘了，体育成绩已经很强大，服装形象还有很大的进步空间。","date":"2016-08-11","like_count":316,"comments_count":28,"thumbs":[{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118380.jpg","width":595,"height":963},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118380.jpg","width":595,"height":963},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118380.jpg","width":320,"height":517},"id":118380}],"created_time":"2016-08-09 14:04:13","title":"超多图｜别再吐槽番茄炒蛋了，中国队也有好设计！","share_pic_url":"https://moment.douban.com/share_pic/post/144460.jpg","type":"1001","id":144460},{"display_style":10001,"is_editor_choice":false,"published_time":"2016-08-11 15:00:00","original_url":"https://movie.douban.com/review/8022358/","url":"https://moment.douban.com/post/144371/?douban_rec=1","short_url":"https://dou.bz/3hGwCi","is_liked":false,"author":{"is_followed":false,"uid":"35986570","url":"https://www.douban.com/people/35986570/","avatar":"https://img1.doubanio.com/icon/u35986570-9.jpg","name":"油炸绿菠萝","is_special_user":false,"n_posts":0,"alt":"","large_avatar":"https://img1.doubanio.com/icon/up35986570-9.jpg","id":"35986570","is_auth_author":false},"column":"看电影","app_css":7,"abstract":"昨天去看了《爱宠大机密》，如热评所说，这才是真\u2022疯狂动物城：两只因为闹矛盾走失的小狗把隐匿在城市各个角落的小动物们都引出来了，上天入地下海，最后在布鲁克林桥上演","date":"2016-08-11","like_count":351,"comments_count":24,"thumbs":[{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118339.jpg","width":300,"height":428},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118339.jpg","width":300,"height":428},"tag_name":"img_1","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118339.jpg","width":300,"height":428},"id":118339}],"created_time":"2016-08-08 14:00:08","title":"凭这22个细节 《爱宠大机密》就不是普普通通的卖萌片","share_pic_url":"https://moment.douban.com/share_pic/post/144371.jpg","type":"1003","id":144371},{"display_style":10001,"is_editor_choice":false,"published_time":"2016-08-11 14:00:00","original_url":"https://read.douban.com/column/1777337/chapter/12030584/?icn=yikeapp","url":"https://moment.douban.com/post/141844/?douban_rec=1","short_url":"https://dou.bz/0sofOd","is_liked":false,"author":{"is_followed":false,"uid":"132095195","url":"https://read.douban.com/author/63700166","avatar":"https://img3.doubanio.com/icon/u132095195-2.jpg","name":"公子羽","is_special_user":false,"n_posts":0,"alt":"","large_avatar":"https://img3.doubanio.com/icon/up132095195-2.jpg","id":"132095195","is_auth_author":false},"column":"海外志","app_css":7,"abstract":"我继续向前走，想看看这段尘封的活历史。仅见的一两个路边微缩地图显示这段路正是当年东西柏林墙遗迹，前面就是波茨坦市地域。一路上偶尔看到路边有残留的水泥钢筋断柱，上面全是青苔，我明白这些就是当年的东西柏林墙残存。","date":"2016-08-11","like_count":40,"comments_count":6,"thumbs":[],"created_time":"2016-06-24 13:33:21","title":"追寻郊外柏林墙之路","share_pic_url":"https://moment.douban.com/share_pic/post/141844.jpg","type":"1007","id":141844},{"display_style":10001,"is_editor_choice":false,"published_time":"2016-08-11 13:00:00","original_url":"https://www.douban.com/note/569624393/","url":"https://moment.douban.com/post/143219/?douban_rec=1","short_url":"https://dou.bz/2JfWgH","is_liked":false,"author":{"is_followed":false,"uid":"summerrrrrrr","url":"https://www.douban.com/people/summerrrrrrr/","avatar":"https://img1.doubanio.com/icon/u7921355-167.jpg","name":"阿狸咖哆","is_special_user":false,"n_posts":0,"alt":"别回头望 歌唱吧人生漫长","large_avatar":"https://img1.doubanio.com/icon/up7921355-167.jpg","id":"7921355","is_auth_author":false},"column":"食记","app_css":7,"abstract":"我爸每次买菜的时候都会走过半个菜市场，搞清楚今天哪个摊子比较便宜，又有哪个摊子的菜是最新鲜的，用方言跟老板聊两句天，然后满意地把买好的菜拎回家。在我眼里，我爸就像一个审阅部队的将军。威风凛凛，特别神气。","date":"2016-08-11","like_count":184,"comments_count":16,"thumbs":[],"created_time":"2016-07-20 13:58:38","title":"藏在菜市场里的情书","share_pic_url":"https://moment.douban.com/share_pic/post/143219.jpg","type":"1001","id":143219},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 12:00:00","original_url":"https://www.douban.com/note/575213947/","url":"https://moment.douban.com/post/144510/?douban_rec=1","short_url":"https://dou.bz/2vQtwj","is_liked":false,"author":{"is_followed":false,"editor_notes":"写作围绕地理、历史和科技。","uid":"ztftom","resume":"我是Vamei。我的写作围绕地理、历史和科技主题，关注人与环境的互动。期待与你交流。","url":"https://www.douban.com/people/ztftom/","avatar":"https://img3.doubanio.com/icon/u3206680-10.jpg","name":"Vamei","is_special_user":false,"last_post_time":"2016-12-03 12:00:00","n_posts":79,"alt":"An Unexpected Journey","large_avatar":"https://img3.doubanio.com/icon/up3206680-10.jpg","id":"3206680","is_auth_author":true},"column":"冷知识","app_css":7,"abstract":"傅园慧无意中泄露了自己身携\u201c超级力量\u201d的秘密。当然，也要感谢她在日常生活中藏起了\u201c洪荒之力\u201d，免得地球遭殃。","date":"2016-08-11","like_count":169,"comments_count":19,"thumbs":[{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118409.jpg","width":500,"height":347},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118409.jpg","width":500,"height":347},"tag_name":"img_1","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118409.jpg","width":320,"height":222},"id":118409}],"created_time":"2016-08-09 21:10:00","title":"\u201c洪荒之力\u201d到底是多大力？","share_pic_url":"https://img3.doubanio.com/f/presto/28e69e95cae2e0e0a577a5da1716a6e540a308d1/images/share_logo.jpg","type":"1001","id":144510},{"display_style":10002,"is_editor_choice":true,"published_time":"2016-08-11 11:30:00","original_url":"https://www.douban.com/note/575083029/","url":"https://moment.douban.com/post/144455/?douban_rec=1","short_url":"https://dou.bz/0lzhDD","is_liked":false,"author":{"is_followed":false,"editor_notes":"植物爱好者，专业饲猫人。","uid":"wanqing0222","resume":"豆瓣阅读作者。业余植物爱好者，专业饲猫人。1985年出生于江苏宜兴，居苏州。中文系毕业，没写过什么东西。电子书《空闲工夫剥野菱》。","url":"https://www.douban.com/people/wanqing0222/","avatar":"https://img1.doubanio.com/icon/u57419345-67.jpg","name":"斯弥","is_special_user":false,"last_post_time":"2017-02-04 09:00:00","n_posts":33,"alt":"傻逼就不要回复我了。","large_avatar":"https://img1.doubanio.com/icon/up57419345-67.jpg","id":"57419345","is_auth_author":true},"column":"萌","app_css":7,"abstract":"猫和獭完全是互相无视的。有时候娃哭得厉害，吉祥会很烦躁，总是一脸忧愁地望着我，示意我做点什么让这个家伙安静下来。","date":"2016-08-11","like_count":723,"comments_count":60,"thumbs":[{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118410.jpg","width":573,"height":764},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118410.jpg","width":573,"height":764},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118410.jpg","width":320,"height":426},"id":118410}],"created_time":"2016-08-09 09:10:09","title":"獭和猫","share_pic_url":"https://moment.douban.com/share_pic/post/144455.jpg","type":"1001","id":144455},{"display_style":10003,"is_editor_choice":false,"published_time":"2016-08-11 10:00:00","original_url":"https://www.douban.com/photos/album/1631305667/","url":"https://moment.douban.com/post/142158/?douban_rec=1","short_url":"https://dou.bz/11LBrg","is_liked":false,"author":{"is_followed":false,"uid":"graceleslie","url":"https://www.douban.com/people/graceleslie/","avatar":"https://img3.doubanio.com/icon/u1484216-54.jpg","name":"范石三","is_special_user":false,"n_posts":0,"alt":"","large_avatar":"https://img3.doubanio.com/icon/up1484216-54.jpg","id":"1484216","is_auth_author":false},"column":"","app_css":7,"abstract":"2013年，我沿着长城旅行了三个月，依着gps记录的轨迹画了这个地图，我从长城西端玉门关河仓城开始骑行，抵达长城东端丹东虎山的时候正好是6093公里。","date":"2016-08-11","like_count":197,"comments_count":11,"thumbs":[{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118357.jpg","width":960,"height":738},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118357.jpg","width":1600,"height":1230},"tag_name":"img_1","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118357.jpg","width":320,"height":246},"id":118357},{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118358.jpg","width":960,"height":738},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118358.jpg","width":1600,"height":1230},"tag_name":"img_2","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118358.jpg","width":320,"height":246},"id":118358},{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118359.jpg","width":960,"height":738},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118359.jpg","width":1600,"height":1230},"tag_name":"img_3","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118359.jpg","width":320,"height":246},"id":118359}],"created_time":"2016-06-30 11:00:54","title":"骑行至长城的尽头","share_pic_url":"https://moment.douban.com/share_pic/post/142158.jpg","type":"1004","id":142158},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 09:00:00","original_url":"https://www.douban.com/note/563382609/","url":"https://moment.douban.com/post/143579/?douban_rec=1","short_url":"https://dou.bz/0f9Hdj","is_liked":false,"author":{"is_followed":false,"editor_notes":"萌银行职员。电子书《我就喜欢做奶酪》","uid":"35550194","resume":"萌银行职员。电子书《我就喜欢做奶酪》","url":"https://www.douban.com/people/35550194/","avatar":"https://img5.doubanio.com/icon/u35550194-26.jpg","name":"树懒爸爸","is_special_user":false,"last_post_time":"2017-02-20 09:00:00","n_posts":34,"alt":"凡有感悟，皆可成书","large_avatar":"https://img5.doubanio.com/icon/up35550194-26.jpg","id":"35550194","is_auth_author":true},"column":"萌","app_css":7,"abstract":"世界上有三种妖怪，好妖怪、坏妖怪、不好不坏的妖怪。好妖怪都扎小辫。坏妖怪都披散着头发。不好不坏蛋妖怪呢\u2014\u2014\u2014是理发师。","date":"2016-08-11","like_count":385,"comments_count":12,"thumbs":[{"medium":{"url":"https://img5.doubanio.com/view/presto/medium/public/t118076.jpg","width":600,"height":567},"description":"","large":{"url":"https://img5.doubanio.com/view/presto/large/public/t118076.jpg","width":600,"height":567},"tag_name":"img_2","small":{"url":"https://img5.doubanio.com/view/presto/small/public/t118076.jpg","width":320,"height":302},"id":118076}],"created_time":"2016-07-26 15:32:32","title":"每天一个短故事，存萌银行","share_pic_url":"https://moment.douban.com/share_pic/post/143579.jpg","type":"1001","id":143579},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 08:00:00","original_url":"https://www.douban.com/note/575023814/","url":"https://moment.douban.com/post/144434/?douban_rec=1","short_url":"https://dou.bz/2SDh1J","is_liked":false,"author":{"is_followed":false,"editor_notes":"杨时旸，影评人，专栏作家。","uid":"1233038","resume":"杨时旸，影评人，专栏作家，《中国新闻周刊》主笔。","url":"https://www.douban.com/people/1233038/","avatar":"https://img3.doubanio.com/icon/u1233038-2.jpg","name":"frozenmoon","is_special_user":false,"last_post_time":"2017-02-12 15:00:00","n_posts":68,"alt":"《并没有如愿以偿的人生》上市","large_avatar":"https://img3.doubanio.com/icon/up1233038-2.jpg","id":"1233038","is_auth_author":true},"column":"","app_css":7,"abstract":"她的狂喜无法掩饰也绝非表演，一切都发自内心，她或许现在会后悔当时为什么没摆个更美的角度，而让自己的怪表情如此泛滥，","date":"2016-08-11","like_count":358,"comments_count":126,"thumbs":[{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118383.jpg","width":526,"height":483},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118383.jpg","width":526,"height":483},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118383.jpg","width":320,"height":293},"id":118383}],"created_time":"2016-08-08 22:10:07","title":"多几个搞笑的傅园慧，少几个哭泣的孙杨吧","share_pic_url":"https://moment.douban.com/share_pic/post/144434.jpg","type":"1001","id":144434},{"display_style":10001,"is_editor_choice":false,"published_time":"2016-08-11 04:00:00","original_url":"https://www.douban.com/note/559798263/","url":"https://moment.douban.com/post/140059/?douban_rec=1","short_url":"https://dou.bz/1P28Vz","is_liked":false,"author":{"is_followed":false,"editor_notes":"文字中人，生活中人。","uid":"pinkonion","resume":"文字中人，生活中人，复杂到一言难尽，简单到不值一提。出版作品有《只愿你曾被这世界温柔相待》 ，《所有年轻人都将在黎明前死去》，《我们心中的怕和爱》。","url":"https://www.douban.com/people/pinkonion/","avatar":"https://img3.doubanio.com/icon/u1026712-81.jpg","name":"水木丁","is_special_user":false,"last_post_time":"2017-02-05 04:00:00","n_posts":18,"alt":"我出新书啦！","large_avatar":"https://img3.doubanio.com/icon/up1026712-81.jpg","id":"1026712","is_auth_author":true},"column":"闲翻书","app_css":7,"abstract":"最近重读了村上春树的《挪威的森林》。村上春树让我感到舒服，并不是因为他是一个女权主义者，根本没那种事，没有什么男权或者女权的问题，他只是对权力本身非常反感，冷眼旁观，看得比任何人都清醒透彻而已。","date":"2016-08-11","like_count":230,"comments_count":18,"thumbs":[],"created_time":"2016-05-24 20:10:05","title":"无所谓女权的村上春树","share_pic_url":"https://moment.douban.com/share_pic/post/140059.jpg","type":"1001","id":140059},{"display_style":10002,"is_editor_choice":false,"published_time":"2016-08-11 00:00:00","original_url":"","url":"https://moment.douban.com/post/144155/?douban_rec=1","short_url":"https://dou.bz/49HapB","is_liked":false,"column":"打鸡血","app_css":7,"abstract":"上个星期这门课我就发现一个白人女生在课堂上特别认真全程笔没有停，手机也不玩。今天我坐在她旁边，发现她拿着一本\u2026\u2026","date":"2016-08-11","like_count":256,"comments_count":179,"thumbs":[{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118411.jpg","width":400,"height":300},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118411.jpg","width":400,"height":300},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118411.jpg","width":320,"height":240},"id":118411}],"created_time":"2016-08-04 08:00:04","title":"打鸡血｜运动员退役后要好好管理自己 2016.08.11","share_pic_url":"https://moment.douban.com/share_pic/post/144155.jpg","type":"1001","id":144155},{"display_style":10003,"is_editor_choice":false,"published_time":"2016-08-11 00:00:00","original_url":"https://www.douban.com/photos/album/38199094/","url":"https://moment.douban.com/post/142524/?douban_rec=1","short_url":"https://dou.bz/3oX08G","is_liked":false,"author":{"is_followed":false,"uid":"januaryrain","url":"https://www.douban.com/people/januaryrain/","avatar":"https://img3.doubanio.com/icon/u28517743-152.jpg","name":"游","is_special_user":false,"n_posts":0,"alt":"","large_avatar":"https://img3.doubanio.com/icon/up28517743-152.jpg","id":"28517743","is_auth_author":false},"column":"","app_css":7,"abstract":"我的工笔画，包括创作和临摹","date":"2016-08-11","like_count":532,"comments_count":41,"thumbs":[{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118081.jpg","width":960,"height":710},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118081.jpg","width":1600,"height":1184},"tag_name":"img_1","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118081.jpg","width":320,"height":236},"id":118081},{"medium":{"url":"https://img3.doubanio.com/view/presto/medium/public/t118085.jpg","width":600,"height":571},"description":"","large":{"url":"https://img3.doubanio.com/view/presto/large/public/t118085.jpg","width":600,"height":571},"tag_name":"img_5","small":{"url":"https://img3.doubanio.com/view/presto/small/public/t118085.jpg","width":320,"height":304},"id":118085},{"medium":{"url":"https://img5.doubanio.com/view/presto/medium/public/t118086.jpg","width":960,"height":769},"description":"","large":{"url":"https://img5.doubanio.com/view/presto/large/public/t118086.jpg","width":1600,"height":1282},"tag_name":"img_6","small":{"url":"https://img5.doubanio.com/view/presto/small/public/t118086.jpg","width":320,"height":256},"id":118086}],"created_time":"2016-07-07 10:30:34","title":"工笔画欣赏","share_pic_url":"https://moment.douban.com/share_pic/post/142524.jpg","type":"1004","id":142524},{"display_style":10001,"is_editor_choice":false,"published_time":"2016-08-11 00:00:00","original_url":"https://www.douban.com/note/571068209/","url":"https://moment.douban.com/post/143165/?douban_rec=1","short_url":"https://dou.bz/4qGJqV","is_liked":false,"author":{"is_followed":false,"uid":"dairiqiang","url":"https://www.douban.com/people/dairiqiang/","avatar":"https://img1.doubanio.com/icon/u3123054-77.jpg","name":"戴日强","is_special_user":false,"n_posts":0,"alt":"《世界那么美不如你好看》","large_avatar":"https://img1.doubanio.com/icon/up3123054-77.jpg","id":"3123054","is_auth_author":false},"column":"","app_css":7,"abstract":"虽然阿婆的故事有很多个版本，但西门町的居民都情愿相信阿婆是选择独自终老来守候彼岸的爱，热情的阿婆在面对那么多眼光时总是微微一笑。或许，阿婆慈祥的笑容和香喷喷的面线糊是西门町最美的爱情传说。","date":"2016-08-11","like_count":255,"comments_count":21,"thumbs":[],"created_time":"2016-07-19 15:03:28","title":"长文｜西门町的爱情故事","share_pic_url":"https://moment.douban.com/share_pic/post/143165.jpg","type":"1001","id":143165}]
     * offset : 7200
     * date : 2016-08-11
     * total : 17
     */

    private int count;
    private int offset;
    private String date;
    private int total;
    private List<PostsBean> posts;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class PostsBean implements Serializable{
        /**
         * display_style : 10002
         * is_editor_choice : false
         * published_time : 2016-08-11 22:00:00
         * original_url :
         * url : https://moment.douban.com/post/144624/?douban_rec=1
         * short_url : https://dou.bz/1QawCH
         * is_liked : false
         * column : 洗洗睡
         * app_css : 7
         * abstract : 无论我们如何地热衷于在碎玻璃上跳舞，总有些门不该被打开，总有些故事刺痛喉咙像烧着烧着就熄灭了的火，心碎的人并不畏惧人群……
         * date : 2016-08-11
         * like_count : 324
         * comments_count : 53
         * thumbs : [{"medium":{"url":"https://img1.doubanio.com/view/presto/medium/public/t118439.jpg","width":460,"height":689},"description":"","large":{"url":"https://img1.doubanio.com/view/presto/large/public/t118439.jpg","width":460,"height":689},"tag_name":"img_1","small":{"url":"https://img1.doubanio.com/view/presto/small/public/t118439.jpg","width":320,"height":479},"id":118439}]
         * created_time : 2016-08-11 14:26:26
         * title : 洗洗睡｜事物的关联令人心碎
         * share_pic_url : https://moment.douban.com/share_pic/post/144624.jpg
         * type : 1001
         * id : 144624
         * author : {"is_followed":false,"editor_notes":"写画撰稿人，凡间食习生。","uid":"sayblack","resume":"奔赴在野路子上，写几篇小文，绘霹雳葫芦，画一点小画。","url":"https://www.douban.com/people/sayblack/","avatar":"https://img3.doubanio.com/icon/u1500312-44.jpg","name":"大霹雳","is_special_user":false,"last_post_time":"2017-02-03 00:00:00","n_posts":35,"alt":"为这宇宙之广漠而终有孤胆。","large_avatar":"https://img3.doubanio.com/icon/up1500312-44.jpg","id":"1500312","is_auth_author":true}
         */

        private int display_style;
        private boolean is_editor_choice;
        private String published_time;
        private String original_url;
        private String url;
        private String short_url;
        private boolean is_liked;
        private String column;
        private int app_css;
        @SerializedName("abstract")
        private String abstractX;
        private String date;
        private int like_count;
        private int comments_count;
        private String created_time;
        private String title;
        private String share_pic_url;
        private String type;
        private int id;
        private AuthorBean author;
        private List<ThumbsBean> thumbs;

        public int getDisplay_style() {
            return display_style;
        }

        public void setDisplay_style(int display_style) {
            this.display_style = display_style;
        }

        public boolean isIs_editor_choice() {
            return is_editor_choice;
        }

        public void setIs_editor_choice(boolean is_editor_choice) {
            this.is_editor_choice = is_editor_choice;
        }

        public String getPublished_time() {
            return published_time;
        }

        public void setPublished_time(String published_time) {
            this.published_time = published_time;
        }

        public String getOriginal_url() {
            return original_url;
        }

        public void setOriginal_url(String original_url) {
            this.original_url = original_url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getShort_url() {
            return short_url;
        }

        public void setShort_url(String short_url) {
            this.short_url = short_url;
        }

        public boolean isIs_liked() {
            return is_liked;
        }

        public void setIs_liked(boolean is_liked) {
            this.is_liked = is_liked;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public int getApp_css() {
            return app_css;
        }

        public void setApp_css(int app_css) {
            this.app_css = app_css;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getShare_pic_url() {
            return share_pic_url;
        }

        public void setShare_pic_url(String share_pic_url) {
            this.share_pic_url = share_pic_url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public List<ThumbsBean> getThumbs() {
            return thumbs;
        }

        public void setThumbs(List<ThumbsBean> thumbs) {
            this.thumbs = thumbs;
        }

        public static class AuthorBean {
            /**
             * is_followed : false
             * editor_notes : 写画撰稿人，凡间食习生。
             * uid : sayblack
             * resume : 奔赴在野路子上，写几篇小文，绘霹雳葫芦，画一点小画。
             * url : https://www.douban.com/people/sayblack/
             * avatar : https://img3.doubanio.com/icon/u1500312-44.jpg
             * name : 大霹雳
             * is_special_user : false
             * last_post_time : 2017-02-03 00:00:00
             * n_posts : 35
             * alt : 为这宇宙之广漠而终有孤胆。
             * large_avatar : https://img3.doubanio.com/icon/up1500312-44.jpg
             * id : 1500312
             * is_auth_author : true
             */

            private boolean is_followed;
            private String editor_notes;
            private String uid;
            private String resume;
            private String url;
            private String avatar;
            private String name;
            private boolean is_special_user;
            private String last_post_time;
            private int n_posts;
            private String alt;
            private String large_avatar;
            private String id;
            private boolean is_auth_author;

            public boolean isIs_followed() {
                return is_followed;
            }

            public void setIs_followed(boolean is_followed) {
                this.is_followed = is_followed;
            }

            public String getEditor_notes() {
                return editor_notes;
            }

            public void setEditor_notes(String editor_notes) {
                this.editor_notes = editor_notes;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getResume() {
                return resume;
            }

            public void setResume(String resume) {
                this.resume = resume;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isIs_special_user() {
                return is_special_user;
            }

            public void setIs_special_user(boolean is_special_user) {
                this.is_special_user = is_special_user;
            }

            public String getLast_post_time() {
                return last_post_time;
            }

            public void setLast_post_time(String last_post_time) {
                this.last_post_time = last_post_time;
            }

            public int getN_posts() {
                return n_posts;
            }

            public void setN_posts(int n_posts) {
                this.n_posts = n_posts;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getLarge_avatar() {
                return large_avatar;
            }

            public void setLarge_avatar(String large_avatar) {
                this.large_avatar = large_avatar;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIs_auth_author() {
                return is_auth_author;
            }

            public void setIs_auth_author(boolean is_auth_author) {
                this.is_auth_author = is_auth_author;
            }
        }

        public static class ThumbsBean {
            /**
             * medium : {"url":"https://img1.doubanio.com/view/presto/medium/public/t118439.jpg","width":460,"height":689}
             * description :
             * large : {"url":"https://img1.doubanio.com/view/presto/large/public/t118439.jpg","width":460,"height":689}
             * tag_name : img_1
             * small : {"url":"https://img1.doubanio.com/view/presto/small/public/t118439.jpg","width":320,"height":479}
             * id : 118439
             */

            private MediumBean medium;
            private String description;
            private LargeBean large;
            private String tag_name;
            private SmallBean small;
            private int id;

            public MediumBean getMedium() {
                return medium;
            }

            public void setMedium(MediumBean medium) {
                this.medium = medium;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public LargeBean getLarge() {
                return large;
            }

            public void setLarge(LargeBean large) {
                this.large = large;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }

            public SmallBean getSmall() {
                return small;
            }

            public void setSmall(SmallBean small) {
                this.small = small;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public static class MediumBean {
                /**
                 * url : https://img1.doubanio.com/view/presto/medium/public/t118439.jpg
                 * width : 460
                 * height : 689
                 */

                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }

            public static class LargeBean {
                /**
                 * url : https://img1.doubanio.com/view/presto/large/public/t118439.jpg
                 * width : 460
                 * height : 689
                 */

                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }

            public static class SmallBean {
                /**
                 * url : https://img1.doubanio.com/view/presto/small/public/t118439.jpg
                 * width : 320
                 * height : 479
                 */

                private String url;
                private int width;
                private int height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }
        }
    }
}
