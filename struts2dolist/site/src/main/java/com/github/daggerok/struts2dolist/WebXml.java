package com.github.daggerok.struts2dolist;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
        urlPatterns = "/*",
        displayName = "JBoss EAP CDI Struts 2",
        initParams = {
                @WebInitParam(
                        description = "Set action suffix as *Page",
                        name = "struts.convention.action.suffix",
                        value = "Page"
                )
        }
)
public class WebXml extends StrutsPrepareAndExecuteFilter {
}
