package org.aguzman.apiservlet.webapp.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.aguzman.apiservlet.webapp.headers.services.ServiceJdbcException;

import java.io.IOException;

@WebFilter("/*")
public class ConexionFilter implements Filter {
    /*@Inject
    @MysqlConn
    private Connection conn;*/


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*try {

            Connection connRequest= this.conn;
            if (connRequest.getAutoCommit()){
                connRequest.setAutoCommit(false);
            }*/
            try {
                //request.setAttribute("conn", connRequest);
                chain.doFilter(request,response);

            }catch (ServiceJdbcException e){
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        /*} catch (SQLException  e) {
            e.printStackTrace();
        }*/
    }
}
