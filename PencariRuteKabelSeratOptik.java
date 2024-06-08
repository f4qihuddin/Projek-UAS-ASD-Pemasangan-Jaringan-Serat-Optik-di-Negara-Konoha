/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectuas_asd;

/**
 *
 * @author advan
 */
public class PencariRuteKabelSeratOptik 
{
    static class Vertex 
    {
        private String namaKota;
        private int[][] lokasiRouter;
        private int jumlahRouter;

        public Vertex(String namaKota) 
        {
            this.namaKota = namaKota;
            this.lokasiRouter = new int[50][2];
            this.jumlahRouter = 0;
        }

        public int[][] ambilLokasiRouter() 
        {
            return lokasiRouter;
        }

        public void tambahLokasiRouter(int x, int y) 
        {
            if (jumlahRouter < lokasiRouter.length) 
            {
                this.lokasiRouter[jumlahRouter][0] = x;
                this.lokasiRouter[jumlahRouter][1] = y;
                jumlahRouter++;
            } 
            else 
            {
                System.out.println("Jumlah lokasi router telah mencapai batas");
            }
        }

        public String ambilNamaKota() 
        {
            return this.namaKota;
        }

        public int ambilJumlahRouter() 
        {
            return this.jumlahRouter;
        }
    }
}
