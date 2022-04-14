import java.util.Scanner;

public class Movie {
    int id;
    String judul;
    int tahun;
    float rating;

    Movie(int i, String j, int t, float r){
        id = i;
        judul = j;
        tahun = t;
        rating = r;
    }
    void tampil(){
        System.out.println("ID = "+ id);
        System.out.println("Judul = "+ judul);
        System.out.println("Tahun = "+ tahun);
        System.out.println("Rating = "+ rating);
    }
}