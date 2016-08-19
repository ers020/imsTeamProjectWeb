package jsp_servlet._navpage;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __nav extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/navPage/nav.jsp", 1471548092304L ,"12.2.1.1.0","America/New_York")) return true;
        return false;
    }
    private weblogic.servlet.jsp.ExpressionInterceptor _jsp_expressionInterceptor = weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.getNonOperExpressionInterceptor();

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private static java.lang.String  _wl_block0 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n\t<!-- BootStrap -->\r\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private static java.lang.String  _wl_block1 ="/resources/css/bootstrap.css\">\r\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private static java.lang.String  _wl_block2 ="/resources/css/bootstrap.min.css\">\r\n\t<script src=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private static java.lang.String  _wl_block3 ="/resources/js/bootstrap.js\"></script>\r\n\t<script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private static java.lang.String  _wl_block4 ="/resources/js/bootstrap.min.js\"></script>\r\n\t\r\n\t<!-- jQuery -->\r\n\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\r\n\t\r\n\t<!-- CSS Google Text -->\r\n\t<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,900\" rel=\"stylesheet\" type=\"text/css\">\r\n\t\r\n\t<!-- Custom CSS -->\r\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private static java.lang.String  _wl_block5 ="/resources/css/index.css\">\r\n<body>\r\n\t<ul>\r\n\t\t<li><a href=\"#\">Home</a></li>\r\n\t\t<li><a href=\"#\">Create Invoice</a></li>\r\n\t\t<li><a href=\"#\">Order Items</a></li>\r\n\t\t<li><a href=\"#\">Check Stock</a></li>\r\n\t\t<li><a href=\"#\">Add Client</a></li>\r\n\t\t<li><a href=\"#\">Update Client</a></li>\r\n\t\t<li><a href=\"#\">Generate Report</a></li>\r\n\t\t<li><a href=\"#\">About</a></li>\r\n\t</ul>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    protected void _jspInit() {
        _jsp_expressionInterceptor = weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.getExpressionInterceptor(getServletConfig());
    }

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            out.write(_jsp_expressionInterceptor.intercept(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.servletContext.contextPath}",java.lang.String.class,pageContext, null ), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.EL));
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(_jsp_expressionInterceptor.intercept(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.servletContext.contextPath}",java.lang.String.class,pageContext, null ), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.EL));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(_jsp_expressionInterceptor.intercept(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.servletContext.contextPath}",java.lang.String.class,pageContext, null ), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.EL));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(_jsp_expressionInterceptor.intercept(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.servletContext.contextPath}",java.lang.String.class,pageContext, null ), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.EL));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(_jsp_expressionInterceptor.intercept(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.servletContext.contextPath}",java.lang.String.class,pageContext, null ), pageContext, weblogic.servlet.jsp.ExpressionInterceptor.Type.EL));
            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            __ee.setStackTrace(weblogic.jsp.internal.jsp.utils.SMAPUtils.loadSMAP(this.getClass()).processStackTrace(__ee.getStackTrace()));
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        } finally {
            javax.servlet.jsp.JspFactory.getDefaultFactory().releasePageContext(pageContext);
        }
    }
}
