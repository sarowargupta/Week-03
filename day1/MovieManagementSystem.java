package com.week3.day1;
class Movie{
    String movieTitle ;
    String director;
    int yearOfRelease;
    double rating;
    Movie next;
    Movie prev;

    // constructor
    public Movie(String movieTitle,String director,int yearOfRelease,double rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class MovieList{
    private Movie head;
    private Movie tail;
    // Add a movie at the beginning
    public void addMovieAtBeginning(String movieTitle,String director,int yearOfRelease,double rating){
        Movie movie =new Movie(movieTitle, director, yearOfRelease, rating);
        movie.next=head;
        movie.prev = null;
        if (head == null) {
            head = tail = movie;
        } else {
            movie.next = head;
            head.prev = movie;
            head = movie;
        }
    }
    // Add a movie at the end
    public void addMovieAtEnd(String movieTitle,String director,int yearOfRelease,double rating){
        Movie movie = new Movie(movieTitle, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = movie;
        } else {
            tail.next = movie;
            movie.prev = tail;
            tail = movie;
        }
    }
    // Add a movie at a specific position
    public void addMovieAtIndex(String movieTitle,String director,int yearOfRelease,double rating,int position){
        if (position <= 0) {
            addMovieAtBeginning(movieTitle, director,yearOfRelease, rating);
            return;
        }

        Movie movie = new Movie(movieTitle, director, yearOfRelease, rating);
        Movie temp = head;
        int index = 0;

        for(int i=1;i<position-1&&temp!=null;i++){
            temp=temp.next;
        }

        if (temp == null || temp.next == null) {
            addMovieAtEnd(movieTitle, director, yearOfRelease, rating);
        } else {
            movie.next = temp.next;
            movie.prev = temp;
            temp.next.prev = movie;
            temp.next = movie;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String movieTitle) {
        Movie temp = head;
        while (temp != null) {
            if (temp.movieTitle.equalsIgnoreCase(movieTitle)) {
                if (temp== head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed: " + movieTitle);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + movieTitle);
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Found Movie: " + temp.movieTitle+ ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Found Movie: " + temp.movieTitle + ", Director: " + temp.director);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        Movie temp = head;
        System.out.println("Movies in Forward Order:");
        while (temp != null) {
            System.out.println(temp.movieTitle + " | " + temp.director + " | " + temp.yearOfRelease + " | " + temp.rating);
            temp = temp.next;
        }
    }


    // Display all movies in reverse order
    public void displayReverse() {
        Movie temp = tail;
        System.out.println("Movies in Reverse Order:");
        while (temp != null) {
            System.out.println(temp.movieTitle + " | " + temp.director + " | " + temp.yearOfRelease + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRating(String newTitle, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.movieTitle.equalsIgnoreCase(newTitle)) {
                temp.rating = newRating;
                System.out.println("Updated rating for " + newTitle + " to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + newTitle);
    }

}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movies = new MovieList();

        movies.addMovieAtBeginning("Happiness", "Sarowar Gupta", 2010, 8.8);
        movies.addMovieAtEnd("Turning point", "Gupta", 1999, 8.7);
        movies.addMovieAtIndex("Vision", "Sarowar", 2014, 9.0, 1);
        movies.displayForward();

        movies.removeByTitle("Happiness");
        movies.displayForward();

        movies.searchByDirector("Sarowar Gupta");
        movies.searchByRating(9.0);

        movies.updateRating("Vision", 9.1);
        movies.displayForward();

        movies.displayReverse();
    }
}


