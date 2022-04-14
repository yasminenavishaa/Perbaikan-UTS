import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        
        MovieMain data = new MovieMain();
        
        
        System.out.print("Masukkan jumlah data movie : ");
        int jumMv = s.nextInt();
        Movie[] e = new Movie[jumMv];
        data.listMv = e;
        
        System.out.println("-----------------------------");
        System.out.println("Masukkan data movie yang ingin dimasukkan : ");
        for(int i = 0; i<jumMv; i++){
            System.out.println("---------------------------");
            System.out.print("ID\t: ");
            int id = s.nextInt();
            System.out.print("Judul\t: ");
            String judul = s1.nextLine();
            System.out.print("Tahun\t: ");
            int tahun = s.nextInt();
            System.out.print("Rating\t: ");
            float rating = s.nextFloat();
           
            Movie m = new Movie(id, judul, tahun, rating);
            data.tambah(m);
        }
            System.out.println("------------------------------------");
            System.out.println("Data keseluruhan Movie");
            data.tampil();
            
            System.out.println("Data Movie setelah sorting selecction asc berdasarkan rating");
            data.bubbleSort();
              
            data.tampil();
            
            System.out.println("____________________________________");
            System.out.println("____________________________________");
            System.out.println("Pencarian data : ");
            System.out.println("Masukkan Rating yang dicari : ");
            System.out.print("Rating : ");
            float cari = s1.nextFloat();
            System.out.println("Menggunakan sequential Search");
            int posisi = data.FindSeqSearch(cari);
            data.Tampilposisi(cari, posisi);
            data.TampilData(cari, posisi);
            System.out.println();
    }

    Movie listMv[];
    int idx;
    
    void tambah(Movie m){
        if(idx < listMv.length){
            listMv[idx] = m;
            idx++;
        }else{
            System.out.println("Data sudah penuh !!");
        }
    }
    void tampil(){
        for(Movie m : listMv){
            m.tampil();
            System.out.println("-----------------------");
        }
    }
    public int FindSeqSearch(float cari){
        int posisi = - 1;
        for(int j = 0; j< listMv.length; j++){
            if(listMv[j].rating == cari){
                posisi = j;
                break;
            }
        }
        return posisi;
    }
    void bubbleSort() {
        for (int i = 0; i < listMv.length - 1; i++) {
            for (int j = 1; j < listMv.length - i; j++) {
                if (listMv[j].rating < listMv[j - 1].rating) {
                    Movie tmp = listMv[j];
                    listMv[j] = listMv[j - 1];
                    listMv[j - 1] = tmp;
                }
            }
        }
    }
    public void Tampilposisi(float x, int pos){
        if(pos !=  -1){
        System.out.println("data : " +x+ " ditemukan pada indeks " + pos);
        }else{           
        System.out.println("data " +x+ "tidak ditemukan");
        }
    }
    public void TampilData(float x, int pos){
        if(pos != -1){
            System.out.println("ID\t : " + listMv[pos].id);
            System.out.println("Judul\t : " + listMv[pos].judul);
            System.out.println("Tahun\t : " + listMv[pos].tahun);
            System.out.println("Rating\t : " + x);
        }else{
            System.out.println("data " +x+ "tidak ditemukan ");
        }
    }
}
