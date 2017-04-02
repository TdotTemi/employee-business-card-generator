/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class LoginServlet extends HttpServlet {

    private UserDAO userDao ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");//call jdbcURL from the webXML and get the values
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");//call jdbcUsername from the webXML and get the values
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");//call jdbcPasswordL from the webXML and get the values

        //initialize bookDAO with values
        userDao = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           getUser(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            //throw new ServletException(ex);
        }
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        //when editing, you need to know the id and then can display the information in bookform page
        String username = request.getParameter("username"); //get username from form
        String password = request.getParameter("password"); //get username from form
        User existingUser = userDao.getUser(username, password); //get existing book so we can get its info later
        request.setAttribute("user", existingUser);
        request.setAttribute("userName", "something");
        if (existingUser != null) {
            //save username in session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
            //request.setAttribute("book", existingBook);
            dispatcher.forward(request, response);

        } else {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            //request.setAttribute("book", existingBook);
            dispatcher.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
