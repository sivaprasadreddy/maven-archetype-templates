package com.sivalabs.springjsfjpa.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivalabs.springjsfjpa.config.SpringApplicationContext;
import com.sivalabs.springjsfjpa.entities.User;
import com.sivalabs.springjsfjpa.services.UserService;
import com.sivalabs.springjsfjpa.utils.JSFUtils;
import com.sivalabs.springjsfjpa.web.view.Theme;

/**
 * @author K. Siva Prasad Reddy
 * Date : 24-Aug-2013
 */
@ManagedBean
@SessionScoped
public class UserSettingsController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(UserSettingsController.class);
	
	private UserService userService;
	
	private String selectedTheme = "aristo";
	private List<String> themes;
	private List<Theme> themePojos;
	
	
	public UserSettingsController()
	{
        
		themes = new ArrayList<String>();  
		themes.add("afterdark");
		themes.add("afternoon");
		themes.add("afterwork");
		themes.add("aristo");
		themes.add("black-tie");
		themes.add("blitzer");
		themes.add("bluesky");
		themes.add("bootstrap");
		themes.add("casablanca");
		themes.add("cruze");
		themes.add("cupertino");
		themes.add("dark-hive");
		themes.add("delta");
		themes.add("dot-luv");
		themes.add("eggplant");
		themes.add("excite-bike");
		themes.add("flick");
		themes.add("glass-x");
		themes.add("home");
		themes.add("hot-sneaks");
		themes.add("humanity");
		themes.add("le-frog");
		themes.add("midnight");
		themes.add("mint-choc");
		themes.add("overcast");
		themes.add("pepper-grinder");
		themes.add("redmond");
		themes.add("rocket");
		themes.add("sam");
		themes.add("smoothness");
		themes.add("south-street");
		themes.add("start");
		themes.add("sunny");
		themes.add("swanky-purse");
		themes.add("trontastic");
		themes.add("ui-darkness");
		themes.add("ui-lightness");
		themes.add("vader");

		//custom theme
		//themes.add("seablue");
		
        themePojos = new ArrayList<Theme>();
        themePojos.add(new Theme("afterdark","afterdark.png"));
        themePojos.add(new Theme("afternoon","afternoon.png"));
        themePojos.add(new Theme("afterwork","afterwork.png"));
        themePojos.add(new Theme("aristo","aristo.png"));
        themePojos.add(new Theme("black-tie","black-tie.png"));
        themePojos.add(new Theme("blitzer","blitzer.png"));
        themePojos.add(new Theme("bluesky","bluesky.png"));
        themePojos.add(new Theme("bootstrap","bootstrap.png"));
        themePojos.add(new Theme("casablanca","casablanca.png"));
        themePojos.add(new Theme("cruze","cruze.png"));
        themePojos.add(new Theme("cupertino","cupertino.png"));
        themePojos.add(new Theme("dark-hive","dark-hive.png"));
        themePojos.add(new Theme("delta","delta.png"));
        themePojos.add(new Theme("dot-luv","dot-luv.png"));
        themePojos.add(new Theme("eggplant","eggplant.png"));
        themePojos.add(new Theme("excite-bike","excite-bike.png"));
        themePojos.add(new Theme("flick","flick.png"));
        themePojos.add(new Theme("glass-x","glass-x.png"));
        themePojos.add(new Theme("home","home.png"));
        themePojos.add(new Theme("hot-sneaks","hot-sneaks.png"));
        themePojos.add(new Theme("humanity","humanity.png"));
        themePojos.add(new Theme("le-frog","le-frog.png"));
        themePojos.add(new Theme("midnight","midnight.png"));
        themePojos.add(new Theme("mint-choc","mint-choc.png"));
        themePojos.add(new Theme("overcast","overcast.png"));
        themePojos.add(new Theme("pepper-grinder","pepper-grinder.png"));
        themePojos.add(new Theme("redmond","redmond.png"));
        themePojos.add(new Theme("rocket","rocket.png"));
        themePojos.add(new Theme("sam","sam.png"));
        themePojos.add(new Theme("smoothness","smoothness.png"));
        themePojos.add(new Theme("south-street","south-street.png"));
        themePojos.add(new Theme("start","start.png"));
        themePojos.add(new Theme("sunny","sunny.png"));
        themePojos.add(new Theme("swanky-purse","swanky-purse.png"));
        themePojos.add(new Theme("trontastic","trontastic.png"));
        themePojos.add(new Theme("ui-darkness","ui-darkness.png"));
        themePojos.add(new Theme("ui-lightness","ui-lightness.png"));
        themePojos.add(new Theme("vader","vader.png"));
        
        //custom theme
       // themePojos.add(new Theme("seablue", "seablue.png"));
        
	}
	
	public UserService getUserService() {
        if(userService == null){
            this.userService = SpringApplicationContext.getBean(UserService.class);
        }
        return userService;
    }
	
	public void setSelectedTheme(String selectedTheme)
	{
		logger.debug("Changed Theme to : "+selectedTheme);
		this.selectedTheme = selectedTheme;
		User loggedinUser = JSFUtils.getLoggedinUser();
		if(loggedinUser != null){
			loggedinUser.setTheme(selectedTheme);
			logger.debug("Setting Current login user theme: "+selectedTheme);
		}
	}
	
	public String getSelectedTheme()
	{
		/*Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(params.containsKey("theme")) {
			selectedTheme = params.get("theme");
		}*/
		User loggedinUser = JSFUtils.getLoggedinUser();
		if(loggedinUser != null){
			selectedTheme = loggedinUser.getTheme();
			logger.debug("Returning current login user theme: "+selectedTheme);
		}
		if(selectedTheme == null || selectedTheme.trim().length()==0){
			selectedTheme = "aristo";
			logger.debug("Default user theme: "+selectedTheme);
		}
		return selectedTheme;
	}
	public void saveUserTheme()
	{
		String theme = getSelectedTheme();
		logger.debug("Save user Theme: "+theme);
		User loggedinUser = JSFUtils.getLoggedinUser();
		JSFUtils.getLoggedinUser().setTheme(theme);
		getUserService().updateUser(loggedinUser);
	}
	public List<String> getThemes()
	{
		return themes;
	}
	
	public List<Theme> getThemePojos()
	{
		return themePojos;
	}
}
