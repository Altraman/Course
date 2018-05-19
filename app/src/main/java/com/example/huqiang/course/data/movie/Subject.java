package com.example.huqiang.course.data.movie;

public class Subject {

    /**
     * rating : {"max":10,"average":8.4,"stars":"45","min":0}
     * title : 复仇者联盟3：无限战争
     * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517753454.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517753454.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517753454.webp"}
     */

    private RatingBean rating;
    private String title;
    private ImagesBean images;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 8.4
         * stars : 45
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
         * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517753454.webp
         * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517753454.webp
         * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517753454.webp
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
