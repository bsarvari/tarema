package org.tarema;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

public class LanguagePreferenceFilter implements Filter {

    public static final List<Locale> supportedLocales = Arrays.asList(new Locale("hu"), new Locale("en"), new Locale("de"));

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
        throws ServletException, IOException {

        String preferredLang = "en";
        boolean hasLangPreferences = ((HttpServletRequest)req).getHeader("Accept-Language") != null;

        if(hasLangPreferences){
            final Enumeration locales = req.getLocales();
            clientLoop: while(locales.hasMoreElements()){
                Locale locale = (Locale) locales.nextElement();
                String clientPreference = locale.getLanguage();
                for(Locale supportedLocale: supportedLocales){
                    if(clientPreference.equals(supportedLocale.getLanguage())){
                        preferredLang = clientPreference;
                        break clientLoop;
                    }
                }
            }
        }
        req.setAttribute("preferredLang", preferredLang);
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }
    @Override
    public void destroy() {}
}
