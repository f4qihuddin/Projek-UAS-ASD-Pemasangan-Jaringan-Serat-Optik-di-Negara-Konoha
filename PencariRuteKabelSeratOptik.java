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

    
}
