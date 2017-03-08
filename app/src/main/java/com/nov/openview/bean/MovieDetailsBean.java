package com.nov.openview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ChinaLHR on 2016/12/19.
 * Email:13435500980@163.com
 */

public class MovieDetailsBean implements Serializable{
    /**
     * rating : {"max":10,"average":5.8,"stars":"30","min":0}
     * reviews_count : 583
     * wish_count : 15551
     * douban_site :
     * year : 2017
     * images : {"small":"http://img6.douban.com/view/movie_poster_cover/ipst/public/p2410569976.jpg","large":"http://img6.douban.com/view/movie_poster_cover/lpst/public/p2410569976.jpg","medium":"http://img6.douban.com/view/movie_poster_cover/spst/public/p2410569976.jpg"}
     * alt : https://movie.douban.com/subject/3230115/
     * id : 3230115
     * mobile_url : https://movie.douban.com/subject/3230115/mobile
     * title : 极限特工3：终极回归
     * do_count : null
     * share_url : http://m.douban.com/movie/subject/3230115
     * seasons_count : null
     * schedule_url : https://movie.douban.com/subject/3230115/cinema/
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["动作","冒险"]
     * collect_count : 45028
     * casts : [{"alt":"https://movie.douban.com/celebrity/1041020/","avatars":{"small":"http://img6.douban.com/img/celebrity/small/53186.jpg","large":"http://img6.douban.com/img/celebrity/large/53186.jpg","medium":"http://img6.douban.com/img/celebrity/medium/53186.jpg"},"name":"范·迪塞尔","id":"1041020"},{"alt":"https://movie.douban.com/celebrity/1025194/","avatars":{"small":"http://img6.douban.com/img/celebrity/small/10695.jpg","large":"http://img6.douban.com/img/celebrity/large/10695.jpg","medium":"http://img6.douban.com/img/celebrity/medium/10695.jpg"},"name":"甄子丹","id":"1025194"},{"alt":"https://movie.douban.com/celebrity/1014002/","avatars":{"small":"http://img6.douban.com/img/celebrity/small/4946.jpg","large":"http://img6.douban.com/img/celebrity/large/4946.jpg","medium":"http://img6.douban.com/img/celebrity/medium/4946.jpg"},"name":"迪皮卡·帕度柯妮","id":"1014002"},{"alt":"https://movie.douban.com/celebrity/1337000/","avatars":{"small":"http://img6.douban.com/img/celebrity/small/1401722517.74.jpg","large":"http://img6.douban.com/img/celebrity/large/1401722517.74.jpg","medium":"http://img6.douban.com/img/celebrity/medium/1401722517.74.jpg"},"name":"吴亦凡","id":"1337000"}]
     * current_season : null
     * original_title : xXx: The Return of Xander Cage
     * summary : 故事聚焦在由范·迪塞尔带头的的特工小队和以甄子丹为首的反派组织之间的对决。在这部作品中，迪塞尔饰演的特工凯奇不再是孤胆英雄，他将与一群出色的伙伴共同作战：塞缪尔·杰克逊饰演的国安局特工，印度女星迪皮卡·帕度柯妮饰演的与凯奇颇有渊源的女猎人，凭借《吸血鬼日记》走红的妮娜·杜波夫扮演的技术专家，《女子监狱》女星露比·罗丝饰演的狙击手,中国当红偶像演员吴亦凡饰演的特工Nicks。
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1014019/","avatars":{"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"D·J·卡卢索","id":"1014019"}]
     * comments_count : 23022
     * ratings_count : 42028
     * aka : ["极限特工：终极回归","3X反恐暴族：重火力回归(港)","限制级战警3: 重返极限(台)","极限特工3","Xander Returns"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 5.8
         * stars : 30
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : http://img6.douban.com/view/movie_poster_cover/ipst/public/p2410569976.jpg
         * large : http://img6.douban.com/view/movie_poster_cover/lpst/public/p2410569976.jpg
         * medium : http://img6.douban.com/view/movie_poster_cover/spst/public/p2410569976.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1041020/
         * avatars : {"small":"http://img6.douban.com/img/celebrity/small/53186.jpg","large":"http://img6.douban.com/img/celebrity/large/53186.jpg","medium":"http://img6.douban.com/img/celebrity/medium/53186.jpg"}
         * name : 范·迪塞尔
         * id : 1041020
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : http://img6.douban.com/img/celebrity/small/53186.jpg
             * large : http://img6.douban.com/img/celebrity/large/53186.jpg
             * medium : http://img6.douban.com/img/celebrity/medium/53186.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1014019/
         * avatars : {"small":"http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"}
         * name : D·J·卡卢索
         * id : 1014019
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : http://img6.douban.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png
             * large : http://img6.douban.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png
             * medium : http://img6.douban.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
