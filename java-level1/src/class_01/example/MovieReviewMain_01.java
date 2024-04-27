package class_01.example;

public class MovieReviewMain_01 {

    public static void main(String[] args) {
        MovieReview movieReview01 = new MovieReview();
        movieReview01.title = "인셉션";
        movieReview01.review = "인생을 무한 루프";

        MovieReview movieReview02 = new MovieReview();
        movieReview02.title = "어바웃 타임";
        movieReview02.review = "인생 시간 영화";

        System.out.println("영화 제목 : " + movieReview01.title + "\n" + "리뷰 : " + movieReview01.review);
        System.out.println("영화 제목 : " + movieReview02.title + "\n" + "리뷰 : " + movieReview02.review);
    }

}