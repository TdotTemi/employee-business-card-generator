/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateBizCardPackage;

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
import employeebusinesscardgenerator.EmpBizCardGenFacade;
import employeebusinesscardgenerator.BusinessCardDesigner;
import employeebusinesscardgenerator.Emp;
import employeebusinesscardgenerator.EmpBizCardDesign1;
import employeebusinesscardgenerator.EmpBizCardDesign2;
import employeebusinesscardgenerator.EmployeeBusinessCardGenerator;

/**
 *
 * @author Admin
 */
public class GenerateBizCardServlet extends HttpServlet {

    private EmpBizCardGenFacade empBizCardFacade;
    private BusinessCardDesigner bizCardDesigner;
    private Emp emp;
    private EmpDAO EmpDao;

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
        EmpDao = new EmpDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //get choosen radio button
            String design = request.getParameter("design"); //get username from form
            switch (design) {
                case "design1":
                    bizCardDesigner = new EmpBizCardDesign1();
                    break;
                case "design2":
                    bizCardDesigner = new EmpBizCardDesign2();
                    break;
                default:
                    break;
            }

            String card = getBusinessCard(request, response);
            String[] lines = card.split("\\n");

            for (String line : lines) {
                if (design.equals("design1")) {
                    out.println("<p style='color:blue'>" + line + "</p>");
                } else {
                    out.println("<p style='color:red'>" + line + "</p>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenerateBizCardServlet.class.getName()).log(Level.SEVERE, null, ex);
            //throw new ServletException(ex);
        }
    }

    private String getBusinessCard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        //when editing, you need to know the id and then can display the information in bookform page
        //get emp
        String selectedOption = request.getParameter("option"); //get username from form 
        //hard code for now
        //Emp existingEmp = EmpDao.getEmp(empName);
        Emp existingEmp = null;
        existingEmp = EmpDao.getEmp(selectedOption);
      

        //get amount
        int amount = Integer.parseInt(request.getParameter("amount"));
        // create object of EmpBizGen
        empBizCardFacade = new EmpBizCardGenFacade(existingEmp, bizCardDesigner, amount);
        String generatedBizCard = empBizCardFacade.generateBusinessCard();
        return generatedBizCard;

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
