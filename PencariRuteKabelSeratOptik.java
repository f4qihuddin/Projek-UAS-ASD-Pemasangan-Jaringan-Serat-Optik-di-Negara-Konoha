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

    static class Edge 
    {
        private Vertex v1;
        private Vertex v2;

        public Edge(Vertex v1, Vertex v2) 
        {
            this.v1 = v1;
            this.v2 = v2;
        }

        public Vertex ambilV1() 
        {
            return v1;
        }

        public Vertex ambilV2() 
        {
            return v2;
        }
    }

    static class Graph 
    {
        private Vertex[] vertices;
        private Edge[] edges;
        private int jumlahVertex;
        private int jumlahEdge;

        public Graph() 
        {
            this.vertices = new Vertex[1000];
            this.edges = new Edge[999];
            this.jumlahVertex = 0;
            this.jumlahEdge = 0;
        }

        public void tambahVertex(Vertex vertex) 
        {
            if (jumlahVertex < vertices.length) 
            {
                vertices[jumlahVertex] = vertex;
                jumlahVertex++;
            }
        }

        public void tambahEdge(Vertex v1, Vertex v2) 
        {
            edges[jumlahEdge] = new Edge(v1, v2);
            jumlahEdge++;
        }

        public Vertex ambilVertex(String namaKota) 
        {
            for (Vertex v : vertices) 
            {
                if (v != null && v.ambilNamaKota().equals(namaKota)) 
                {
                    return v;
                }
            }
            return null;
        }

        public Edge ambilEdge(int indeksEdge) 
        {
            return edges[indeksEdge];
        }
    }

    public static double hitungJarak(int x1, int y1, int x2, int y2) 
    {
        return Math.sqrt(Math.pow((double)x2 - (double)x1, 2) + Math.pow((double)y2 - (double)y1, 2));
    }

    public static double hitungJarakTerdekat(Vertex kota1, Vertex kota2) 
    {
        int[][] lokasiRouter1 = kota1.ambilLokasiRouter();
        int[][] lokasiRouter2 = kota2.ambilLokasiRouter();
        double jarakMin = Double.MAX_VALUE;

        for (int i = 0; i < kota1.ambilJumlahRouter(); i++) 
        {
            for (int j = 0; j < kota2.ambilJumlahRouter(); j++) 
            {
                double jarak = hitungJarak(lokasiRouter1[i][0], lokasiRouter1[i][1], lokasiRouter2[j][0], lokasiRouter2[j][1]);
                if (jarak < jarakMin) 
                {
                    jarakMin = jarak;
                }
            }
        }
        return jarakMin;
    }
    
    public static boolean isUppercase(String input)
    {
       return input != null && input.matches("[A-Z]+");
    }

    public static void main(String[] args) 
    {
        Graph graph = new Graph();
        Scanner sc = new Scanner(System.in);

        double[] jarakTotalJaringan = new double[999];
        int indeksJaringan = 0;

        while (true) 
        {
            int inputJumlahKota = sc.nextInt();
            sc.nextLine();

            if (inputJumlahKota == 0) 
            {
                break;
            } 
            else 
            {
                if (inputJumlahKota < 1 || inputJumlahKota > 1000) 
                {
                    System.out.println("Jumlah kasus uji harus berada di rentang 1 - 1000 kota");
                } 
                else 
                {
                    int i = 0;
                    while (i < inputJumlahKota) 
                    {
                        String input1 = sc.nextLine();
                        String[] subInput1 = input1.split("\\s+");

                        String namaKota = subInput1[0];
                        int inputJumlahRouter = Integer.parseInt(subInput1[1]);
                        boolean namaKotaKapital = isUppercase(namaKota);
                        if ((!namaKotaKapital || namaKota.length() > 15) && (inputJumlahRouter < 1 || inputJumlahRouter > 50))
                        {
                          System.out.println("Nama Kota dan Kandidat Lokasi Router Melebihi Batas Maksimal");
                        }
                        else if (!namaKotaKapital || namaKota.length() > 15)
                        {
                          System.out.println("Nama Kota Harus Kapital dan Maksimal 15 Huruf");
                        }
                        else if (inputJumlahRouter < 1 || inputJumlahRouter > 50) 
                        {
                          System.out.println("Jumlah kandidat lokasi router harus berada di rentang 1 - 50");
                        } 
                        else
                        {
                          i++;
                          Vertex kota = new Vertex(namaKota);
                          graph.tambahVertex(kota);
                          
                          int j = 0;
                          while (j < inputJumlahRouter) 
                          {
                              int x = sc.nextInt();
                              int y = sc.nextInt();
                                  
                              if ((x >= -10000 && x <= 10000 ) && (y >= -10000 && y <= 10000))
                              {
                                kota.tambahLokasiRouter(x, y);
                                j++;
                              }
                              else
                              {
                                System.out.println("Koordinat (x, y) Harus Berada di Rentang (-10000 <= x, y <= 10000)");
                              }
                          }
                          sc.nextLine();                               
                        }
                    }

                    
    
}
