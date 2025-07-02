package class_01.example;

public class MovieReviewMain_02 {

    public static void main(String[] args) {
        MovieReview[] movieReviews = new MovieReview[2];

        MovieReview movieReview01 = new MovieReview();
        movieReview01.title = "인셉션";
        movieReview01.review = "인생을 무한 루프";
        movieReviews[0] = movieReview01;

        MovieReview movieReview02 = new MovieReview();
        movieReview02.title = "어바웃 타임";
        movieReview02.review = "인생 시간 영화";
        movieReviews[1] = movieReview02;

        for (MovieReview movieReview : movieReviews) {
            System.out.println("영화 제목 : " + movieReview.title + "\n" + "리뷰 : " + movieReview.review);
        }
    }

}