
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet{
    
    String sit;
    ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /*String aluno = req.getParameter("aluno");
        String telefone = req.getParameter("telefone");
        resp.getWriter().print(aluno);
        resp.getWriter().print("\n");
        resp.getWriter().print(telefone);*/
        String nome = (String) req.getParameter("nome");
        double P1 = Double.parseDouble((String) req.getParameter("P1"));
        double ProjAula = Double.parseDouble((String) req.getParameter("ProjAula"));
        double Trabalho = Double.parseDouble((String) req.getParameter("Trabalho"));
        double freq = Double.parseDouble((String) req.getParameter("freq"));
        double PF = Double.parseDouble((String) req.getParameter("PF"));
        /*if(acao.equals("enviar")){
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }else if (acao.equals("")){
            req.getRequestDispatcher("/logout.html").forward(req, resp);
        }*/
        
       double media1 = 0.7 * ((P1 + Trabalho) / 2.0) + ProjAula * 0.3;
       boolean pf = false;
        
        if (freq >= 75) {
            if (media1 >= 7.5) {
                System.out.println("Aprovado");
               // resp.getWriter().print("Aprovado");
                sit = "Aprovado";
            } else if (media1 < 3.0) {
                System.out.println("Reprovado");
               // resp.getWriter().print("Reprovado");
                sit = "Reprovado";
            } else {
                pf = true;
            }

            if (pf == true) {
                if (((PF + media1) / 2.0) >= 5.0) {
                    System.out.println("Aprovado");
                   // resp.getWriter().print("Aprovado");
                    sit = "Aprovado";
                } else {
                    System.out.println("Reprovado");
                    //resp.getWriter().print("Reprovado");
                    sit = "Reprovado";
                }
            }
        } else {
            
            //resp.getWriter().print("Reprovado");
            sit = "Reprovado";
        }
        
        
        
        Aluno a = new Aluno(nome, P1, ProjAula, Trabalho, freq, PF, sit);
        listaAluno.add(a);
        req.getServletContext().setAttribute("Aluno", listaAluno);
        
        
        
        
        resp.getWriter().print("<html>");
        resp.getWriter().print("<body>");
        resp.getWriter().print("<table border=\"1px\">");
        resp.getWriter().print("<thead >");
        resp.getWriter().print("<tr>");
        resp.getWriter().print("<th>Nome</td>");
        resp.getWriter().print("<th >P1</td>");
        resp.getWriter().print("<th >ProjAula</td>");
        resp.getWriter().print("<th >Trabalho</td>");
        resp.getWriter().print("<th >Frequencia</td>");
        resp.getWriter().print("<th >PF</td>");
        resp.getWriter().print("<th >Situação</td>");
        resp.getWriter().print("</tr>");
        resp.getWriter().print("</thead>");
        resp.getWriter().print("<tbody>");
        for(Aluno aluno:listaAluno){
         resp.getWriter().print("<tr>");   
         resp.getWriter().print("<td >"+aluno.getNome()+"</td>");
         resp.getWriter().print("<td >"+aluno.getP1()+"</td>");
         resp.getWriter().print("<td >"+aluno.getProjAula()+"</td>");
         resp.getWriter().print("<td >"+aluno.getTrabalho()+"</td>");
         resp.getWriter().print("<td >"+aluno.getFreq()+"</td>");
         resp.getWriter().print("<td >"+aluno.getPF()+"</td>");
         resp.getWriter().print("<td >"+aluno.getSituacao()+"</td>");
         resp.getWriter().print("</tr>");
        }
        resp.getWriter().print("</tbody>");
        resp.getWriter().print("</table>");
        resp.getWriter().print("</body>");
        resp.getWriter().print("</html>");
        
        
        
        
        
        
        
        
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    
}