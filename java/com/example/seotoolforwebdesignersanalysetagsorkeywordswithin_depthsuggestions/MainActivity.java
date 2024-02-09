package com.example.seotoolforwebdesignersanalysetagsorkeywordswithin_depthsuggestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.CaseMap;
import android.media.tv.TvContentRating;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public ProgressDialog mProgressDialog;

//    private TabLayout tabLayout;
//    private ViewPager2 viewPager2;
//    private Tab_Adapter adapter;
    //Square Click Left
    ConstraintLayout cl_oneClick, cl_twoClick, cl_threeClick, cl_fourClick, cl_fiveClick;
    //Activate ImageView
    public ImageView iv_wbckg1, iv_wbckg2, iv_wbckg3, iv_wbckg4, iv_wbckg5;
    //InActive ImageView
    public ImageView iv_wthoutbckg1, iv_wthoutbckg2, iv_wthoutbckg3, iv_wthoutbckg4, iv_wthoutbckg5;
    //The Main Layouts
    public ConstraintLayout cl_main1, cl_scoreLandingPAge, cl_compareSites_SEO, cl_brokenLinks, cl_settings;
    //Bottom Press Back Bar
    public ConstraintLayout cl_press_back_bottom_bar;
    //Left Most Vertical Bar
    public ConstraintLayout cl_leftVertBar;
    //Right Most ConstrintLAyout Container for the Three Layouts
    public ConstraintLayout cl_rightMost_Contianer_4d4LAyouts;
    public WebView webView_krt;

//arrow_top
//arrow_down
    public ImageView iv_arrow_top, iv_arrow_down;
//recent_bar
    public ConstraintLayout recents_bar_CL;
//listview
    public ListView links_LV;
//no recents TextView
    public TextView textView_norecents;
//Score n Analysis
    public ConstraintLayout score_n_analysis_CL;
    public boolean arrow_down_bool=false;public ConstraintLayout cl_scoreanalysis;
//New Imported
    public String surl;
    public boolean bool_sutxt0, bool_sutxt1, bool_sutxt2, bool_sutxt3, bool_sutxt4, bool_sutxt5, bool_sutxt6, bool_sutxt7, bool_sutxt8, bool_sutxt9, bool_sutxt10, bool_sutxt11, bool_sutxt12, bool_sutxt13, bool_sutxt14, bool_sutxt15, bool_sutxt16, bool_sutxt17, bool_sutxt18, bool_sutxt19;
    //1. URL, HTML
    public int no_of_subDirectories_inURL;
    public String surl_subDomain, surl_protocol, surl_rootDomain, surl_topLevelDomain;
    public String[] surl_sd_a = new String[500];
    public String ip_address_str;
    public String  surl_report, string_url_editText;
    public boolean url_valid_on_bool, website_secured_on_bool;
    public int key_pos;
    public char keyLastSecond;
    public int no_of_dots;
    public String html_string;



    //2. TITLE
    public int title_char_count, title_word_count, title_ws_count;
    public String title_string, title_report;
    public String[] title_keywords_a = new String[500];

    //3. HEADERS
    public boolean h1_bool, h2_bool, h3_bool, h4_bool, h5_bool, h6_bool;
    public String[] h1_total_a = new String[500];
    public String[] h2_total_a = new String[500];
    public String[] h3_total_a = new String[500];
    public String[] h4_total_a = new String[500];
    public String[] h5_total_a = new String[500];
    public String[] h6_total_a = new String[500];
    public String[] headers_keywords_total_ = new String[2000];
    public int h1_twords, h2_twords, h3_twords, h4_twords, h5_twords, h6_twords;
    public int h1_tws, h2_tws, h3_tws, h4_tws, h5_tws, h6_tws;//white spaces
    public int h1_char_count, h2_char_count, h3_char_count, h4_char_count, h5_char_count, h6_char_count;
    public String headers_report_h1_h6;
    public String h1_report, h2_report, h3_report, h4_report, h5_report, h6_report;
    public String h1_string, h2_string, h3_string, h4_string, h5_string, h6_string;
    public String h1_string_ftc, h2_string_ftc, h3_string_ftc, h4_string_ftc, h5_string_ftc, h6_string_ftc;
    public int h1_size, h2_size, h3_size, h4_size, h5_size, h6_size;

    //4. BODY tag
    public int p_tags_size, div_tags_size, h1_tags_size, h2_tags_size, h3_tags_size, h4_tags_size, h5_tags_size, h6_tags_size, img_tags_size, href_tags_size, meta_description_tags_size, meta_keywords_size, meta_author_size, meta_robots_size, meta_view_port_size, link_rel_canonical_tag_size;
    public String body_report;
    public boolean p_tags_bool, div_tags_bool, h1_tags_bool, h2_tags_bool, h3_tags_bool, h4_tags_bool, h5_tags_bool, h6_tags_bool, img_tags_bool, href_tags_bool, meta_description_tags_bool, meta_author_bool, meta_keywords_bool, meta_robots_bool, meta_view_port_bool, link_rel_canonical_tag_bool;
    public String meta_keywords_string, meta_author_string, meta_description_string, meta_viewport_string, rel_canonical;
    public int meta__tags_total;

    //5. LINKS Tag
    public boolean links_bool;
    public int links_count, link_text_count_size_numbers;
    public String[] highlighted_text_str_a = new String[2000];
    public String[] highlightedLink_str_a = new String[2000];
    public String href_strings_report;

    //6. IMAGES Tag
    public boolean image_bool;
    public boolean[] img_alt_bool = new boolean[500];
    public String[] img_alt_value = new String[500];
    public String[] img_res_value = new String[500];
    public String[] img_linksrc_value = new String[500];
    public String img_report_string;
    public int img_count_size, img_alt_count_size; //refers to alt count

    //7,8, KEYWORDS    ( 7 is for URL n HTML combined )
    public int total_keywords_count;// =  img_alt_count_size + links_count + h1_twords + h2_twords + h3_twords + h4_twords + h5_twords+ h6_twords + title_word_count
    public String[] total_keywords_a = new String[500];  //image_alt_value[i] + highlighted_text_str_a[i] + title_keywords_a[i] + h1_total_a[i] + h2_total_a[i] + h3_total_a[i] + h4_total_a[i] + h5_total_a[i] + h6_total_a[i];
    public String keywords_report;

    //9, 11, 12, 13, 14
    // public String meta_keywords_string, meta_author_string, meta_description_string, meta_viewport_string, rel_canonical;
    //public boolean meta_description_tags_bool, meta_author_bool, meta_keywords_bool, meta_robots_bool, meta_view_port_bool, link_rel_canonical_tag_bool;
    //public int meta_description_tags_size, meta_keywords_size, meta_author_size, meta_robots_size, meta_view_port_size, link_rel_canonical_tag_size;
    public String page_favicon_report, meta_robots_string, rel_canonical_report_string;
    public String meta_robots_report, meta_keywords_report, meta_author_report, meta_description_report, meta_viewport_report, rel_canonical_report;
    public String string_seo_page_full_report;
    //Boolean for Overview Items
    public boolean bool_ovv1urlreport, bool_ovv2title, bool_ovv3metaDescipt, bool_ovv4metaRobots, bool_ovv5metaViewPort, bool_ovv6relCanonical, bool_ovv7metaAuthor, bool_ovv8metaKeywords, bool_ovv9headerH1, bool_ovv10headerH2, bool_ovv11headerH3, bool_ovv12Links, bool_ovv13imagesAlt;
    //Boolean for Header Items
    public boolean bool_hdrs1, bool_hdrs2, bool_hdrs3, bool_hdrs4, bool_hdrs5, bool_hdrs6;
    //wathouba booleans of items/elements/tags
    public boolean bool_favicon, bool_images, bool_metaTags_forTheWholeFIVE;


//Overview Elements
//TV headers
public TextView TVhead_ovv1, TVhead_ovv3, TVhead_ovv4, TVhead_ovv5, TVhead_ovv6, TVhead_ovv7, TVhead_ovv8, TVhead_ovv9, TVhead_ovv10, TVhead_ovv11, TVhead_ovv12, TVhead_ovv14, TVhead_ovv15;
//TV body
public TextView TV_bodyovv1, TV_bodyovv3, TV_bodyovv4, TV_bodyovv5, TV_bodyovv6, TV_bodyovv7, TV_bodyovv8, TV_bodyovv9, TV_bodyovv10, TV_bodyovv11, TV_bodyovv12, TV_bodyovv14, TV_bodyovv15;
//IV tick
public ImageView IVtick_ovv1, IVtick_ovv3, IVtick_ovv4, IVtick_ovv5, IVtick_ovv6, IVtick_ovv7, IVtick_ovv8, IVtick_ovv9, IVtick_ovv10, IVtick_ovv11, IVtick_ovv12, IVtick_ovv14, IVtick_ovv15;
//IV cross
public ImageView IVcross_ovv1, IVcross_ovv3, IVcross_ovv4, IVcross_ovv5, IVcross_ovv6, IVcross_ovv7, IVcross_ovv8, IVcross_ovv9, IVcross_ovv10, IVcross_ovv11, IVcross_ovv12, IVcross_ovv14, IVcross_ovv15;

//HEADER(s): 7
//TV headers
public TextView TVhead_hdrs1, TVhead_hdrs3, TVhead_hdrs4, TVhead_hdrs5, TVhead_hdrs6, TVhead_hdrs7, TVhead_hdrs8;
//TV body
public TextView TV_bodyhdrs1, TV_bodyhdrs3, TV_bodyhdrs4, TV_bodyhdrs5, TV_bodyhdrs6, TV_bodyhdrs7, TV_bodyhdrs8;
//IV tick
public ImageView IVtick_hdrs1, IVtick_hdrs3, IVtick_hdrs4, IVtick_hdrs5, IVtick_hdrs6, IVtick_hdrs7, IVtick_hdrs8;
//IV cross
public ImageView IVcross_hdrs1, IVcross_hdrs3, IVcross_hdrs4, IVcross_hdrs5, IVcross_hdrs6, IVcross_hdrs7, IVcross_hdrs8;

//New Views: TextView(s), to be initialized ..
    public TextView tvHTML_opseo, tvBODY_opseo, tvLINKS_opseo, tvIMAGESALT_opseo, tvREL_LINK_CANONICAL, tvFAVICON; //tvOVV_urlstructure, tvOVV_title, tvOVV_metaDesc, tvOVV_metaReports, tvOVV_metaViewPort, tvOVV_relCanonicalLink, tvOVV_metaAuthor, tvOVV_metaKeywords, tvOVV_meta
    //Heading
    public String strovvhead_url, strovvhead_title, strovvhead_metaDescrpsn, strovvhead_Robots, strovvhead_ViewPort, strovvhead_RelLinkCanonical, strovvhead_MEtaAuthor, strovvhead_MetaKeywords, strovvhead_H1, strovvhead_H2, strovvhead_H3, strovvhead_H4, strovvhead_H5, strovvhead_H6, strovvhead_Links, strovvhead_Images;
    //Content
    public String strovvbody_url, strovvbody_title, strovvbody_metaDescrpsn, strovvbody_Robots, strovvbody_ViewPort, strovvbody_RelLinkCanonical, strovvbody_MEtaAuthor, strovvbody_MetaKeywords, strovvbody_H1, strovvbody_H2, strovvbody_H3, strovvbody_H4, strovvbody_H5, strovvbody_H6, strovvbody_Links, strovvbody_Images;

    public TextView sitename_tv;
    final int[] count = new int[1];
    public TextView textView_keywords;
    public TextView tv_metaDescr, tv_metaRobots, tv_metaViewPort, tv_reclCanonicalTag, tv_metaAuthor, tv_metaKeywords;
                /*
                tv_metaDescr.setText(meta_description_report);//
                tv_metaRobots.setText(meta_robots_report);//
                tv_metaViewPort.setText(meta_viewport_report);//
                tv_reclCanonicalTag.setText(rel_canonical_report);//
                tv_metaAuthor.setText(meta_author_report);//
                tv_metaKeywords.setText(meta_keywords_report);//
                */

//View Port views VARIABLES
    public TextView tv_topSCOREVIEWPORT_VP, tv_designation, tv_titleonVP, tv_sampleRedVP;

//Scoring Variables
    public float int_score_general, int_score_content, int_score_speed, int_score_structure;
    public float int_percent_score_general, int_percent_score_content, int_percent_score_speed, int_percent_score_structure;

//end BOOLEAN value Result
public boolean imgALT=false;
//time To Load numeric long value
final long[] timeToLoad = new long[1];

//ProgressBar for the ScoreCard
    public ProgressBar PB_general, PB_content, PB_speed, PB_structure;
    //Progress TexView Percentage
    public TextView TV_general, TV_content, TV_speed, TV_structure;
    //TextView Score Remarks
    public TextView tv_remarks_GENERAL, tv_remarks_CONTENT, tv_remarks_SPEED, tv_remarks_STRUCTURE;

    public String str_speed_designation;
    public ConstraintLayout CLabove1, CLabove2, CLabove3, CLabove5, CLabove6, CLabove7;       public ConstraintLayout CLabove0;
    public WebView CLabove4;
//HGIHabove0123456
    public ConstraintLayout HIGHabove0;
    //Highlighters for IV+TV
    public ConstraintLayout HIGHabove1, HIGHabove2, HIGHabove3, HIGHabove4, HIGHabove5, HIGHabove6, HIGHabove7;
    //HTML String
    public String html_string_async;
    public WebView webView_domainAuthority;

//initial variables of recents & ListView
public String[] str_arr_links = new String[1000];
    //public char s

    int int_str_total_links_length;
    int in_arr_count;
    char[] char_total_links;
    TextView textView;
    String space_plus_url;
    public boolean da_bool=false;
    public WebView webView_checkSCORE;
    public String string_final_spee_score_remarks, string_final_speed_percentage;
    public float final_speed_score_percentage;
    public float final_speed_score_in_millis;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        webView_checkSCORE=findViewById(R.id.webView_checkSCORE);
        for(int i=0;i<1000;++i){
            str_arr_links[i]="";
        }
//SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

//TextView remarks
        tv_remarks_GENERAL=findViewById(R.id.genTVid);
        tv_remarks_STRUCTURE=findViewById(R.id.fgpStrucTVid);
        tv_remarks_SPEED=findViewById(R.id.fgpSpeedTVid);
        tv_remarks_CONTENT=findViewById(R.id.conTVid);

//TextView for Progress on Score Card initialization
        TV_general=findViewById(R.id.genTVscore);
        TV_content=findViewById(R.id.conTVscore);
        TV_speed=findViewById(R.id.fgpSpeedTVscore);
        TV_structure=findViewById(R.id.fgpStrucTVscore);


//Progress Initialization
        PB_general=findViewById(R.id.progressGEN);
        PB_content=findViewById(R.id.progressCON);
        PB_speed=findViewById(R.id.progressSPEED);
        PB_structure=findViewById(R.id.progressSTRUC);


//Scoring Numbers initialization
        int_score_general=0;
        int_score_content=0;
        int_score_speed=0;
        int_score_structure=0;


//View Port
        tv_topSCOREVIEWPORT_VP=findViewById(R.id.tv_topSCORE_viewport_VP);
        tv_designation=findViewById(R.id.tv_designation);
        tv_titleonVP=findViewById(R.id.tv_titleonVP);
        tv_sampleRedVP=findViewById(R.id.tv_sampleREDonVP);


//Meta Tags Views IDs initilization
        tv_metaDescr=findViewById(R.id.tvBody14);
        tv_metaRobots=findViewById(R.id.tgnm15);
        tv_metaViewPort=findViewById(R.id.tvBody16);
        tv_reclCanonicalTag=findViewById(R.id.tgnm17);
        tv_metaAuthor=findViewById(R.id.tvBody18);
        tv_metaKeywords=findViewById(R.id.tgnm19);


//Score card Click:
        HIGHabove0=findViewById(R.id.HIGHabove0);
        webView_domainAuthority=findViewById(R.id.CLabhi4);
        sitename_tv=findViewById(R.id.sitenameorurlTVid);
        textView_keywords=findViewById(R.id.tv_KEYWORDS);


//OPSEO: HTML, Overview, Headers, Body, HyperLinks, Images/Alt, Rel = Link Canonical Tag, Favicon
        tvHTML_opseo=findViewById(R.id.tv_HTML);//IV / TV
        tvBODY_opseo=findViewById(R.id.tv_BODY);
        tvLINKS_opseo=findViewById(R.id.tv_HYPERLINKS);
        tvIMAGESALT_opseo=findViewById(R.id.tv_IMG_ALT);
        tvREL_LINK_CANONICAL=findViewById(R.id.tv_REL_CANONICAL);
        tvFAVICON=findViewById(R.id.tv_FAVICON);



//Overview
        //TV headers
        TVhead_ovv1=findViewById(R.id.headtv1);
        TVhead_ovv3=findViewById(R.id.headtv3);
        TVhead_ovv4=findViewById(R.id.headtv4);
        TVhead_ovv5=findViewById(R.id.headtv5);
        TVhead_ovv6=findViewById(R.id.headtv6);
        TVhead_ovv7=findViewById(R.id.headtv7);
        TVhead_ovv8=findViewById(R.id.headtv8);
        TVhead_ovv9=findViewById(R.id.headtv9);
        TVhead_ovv10=findViewById(R.id.headtv10);//H1 head
        TVhead_ovv11=findViewById(R.id.headtv11);//H2 head
        TVhead_ovv12=findViewById(R.id.headtv12);//H3 head
        TVhead_ovv14=findViewById(R.id.headtv14);
        TVhead_ovv15=findViewById(R.id.headtv15);
        //TV body
        TV_bodyovv1=findViewById(R.id.bodytv1);
        TV_bodyovv3=findViewById(R.id.bodytv3);
        TV_bodyovv4=findViewById(R.id.bodytv4);
        TV_bodyovv5=findViewById(R.id.bodytv5);
        TV_bodyovv6=findViewById(R.id.bodytv6);
        TV_bodyovv7=findViewById(R.id.bodytv7);
        TV_bodyovv8=findViewById(R.id.bodytv8);
        TV_bodyovv9=findViewById(R.id.bodytv9);
        TV_bodyovv10=findViewById(R.id.bodytv10);//H1 body
        TV_bodyovv11=findViewById(R.id.bodytv11);//H2 body
        TV_bodyovv12=findViewById(R.id.bodytv12);//H3 body
        TV_bodyovv14=findViewById(R.id.bodytv14);
        TV_bodyovv15=findViewById(R.id.bodytv15);
        //IV tick
        IVtick_ovv1=findViewById(R.id.img11);
        IVtick_ovv3=findViewById(R.id.img31);
        IVtick_ovv4=findViewById(R.id.img41);
        IVtick_ovv5=findViewById(R.id.img51);
        IVtick_ovv6=findViewById(R.id.img61);
        IVtick_ovv7=findViewById(R.id.img71);
        IVtick_ovv8=findViewById(R.id.img81);
        IVtick_ovv9=findViewById(R.id.img91);
        IVtick_ovv10=findViewById(R.id.img101);//h1 tick
        IVtick_ovv11=findViewById(R.id.img111);//h2 tick
        IVtick_ovv12=findViewById(R.id.img121);//h3 tick
        IVtick_ovv14=findViewById(R.id.img141);
        IVtick_ovv15=findViewById(R.id.img151);
        //IV cross
        IVcross_ovv1=findViewById(R.id.img12);
        IVcross_ovv3=findViewById(R.id.img32);
        IVcross_ovv4=findViewById(R.id.img42);
        IVcross_ovv5=findViewById(R.id.img52);
        IVcross_ovv6=findViewById(R.id.img62);
        IVcross_ovv7=findViewById(R.id.img72);
        IVcross_ovv8=findViewById(R.id.img82);
        IVcross_ovv9=findViewById(R.id.img92);
        IVcross_ovv10=findViewById(R.id.img102);//h1 cross
        IVcross_ovv11=findViewById(R.id.img112);//h2 cross
        IVcross_ovv12=findViewById(R.id.img122);//h3 cross
        IVcross_ovv14=findViewById(R.id.img142);
        IVcross_ovv15=findViewById(R.id.img152);

//Headers(hdrs)
        //TV headers
        TVhead_hdrs1=findViewById(R.id.headtvh1);
        TVhead_hdrs3=findViewById(R.id.headtvh3);
        TVhead_hdrs4=findViewById(R.id.headtvh4);
        TVhead_hdrs5=findViewById(R.id.headtvh5);
        TVhead_hdrs6=findViewById(R.id.headtvh6);
        TVhead_hdrs7=findViewById(R.id.headtvh7);
         //TV body
        TV_bodyhdrs1=findViewById(R.id.bodytvh1);
        TV_bodyhdrs3=findViewById(R.id.bodytvh3);
        TV_bodyhdrs4=findViewById(R.id.bodytvh4);
        TV_bodyhdrs5=findViewById(R.id.bodytvh5);
        TV_bodyhdrs6=findViewById(R.id.bodytvh6);
        TV_bodyhdrs7=findViewById(R.id.bodytvh7);
        //IV tick
        IVtick_hdrs1=findViewById(R.id.imgh11);
        IVtick_hdrs3=findViewById(R.id.imgh31);
        IVtick_hdrs4=findViewById(R.id.imgh41);
        IVtick_hdrs5=findViewById(R.id.imgh51);
        IVtick_hdrs6=findViewById(R.id.imgh61);
        IVtick_hdrs7=findViewById(R.id.imgh71);
        //IV cross
        IVcross_hdrs1=findViewById(R.id.imgh12);
        IVcross_hdrs3=findViewById(R.id.imgh32);
        IVcross_hdrs4=findViewById(R.id.imgh42);
        IVcross_hdrs5=findViewById(R.id.imgh52);
        IVcross_hdrs6=findViewById(R.id.imgh62);
        IVcross_hdrs7=findViewById(R.id.imgh72);

        //Overview
        bool_ovv1urlreport=false;//URL Structure
        bool_ovv2title=false;//Title
        bool_ovv3metaDescipt=false;//MEta Descri ..
        bool_ovv4metaRobots=false;//" Robots
        bool_ovv5metaViewPort=false;//" Viewport
        bool_ovv6relCanonical=false;//" canonical link
        bool_ovv7metaAuthor=false;//" author tag
        bool_ovv8metaKeywords=false;//" keywords tag
        bool_ovv9headerH1=false;//header 1
        bool_ovv10headerH2=false;//header 2
        bool_ovv11headerH3=false;//header 3
        bool_ovv12Links=false;//Links
        bool_ovv13imagesAlt=false;//Images
        //Headers
        bool_hdrs1=false;//header 1
        bool_hdrs2=false;//header 24
        bool_hdrs3=false;//header 3
        bool_hdrs4=false;//header 4
        bool_hdrs5=false;//header 5
        bool_hdrs6=false;//header 6
        iv_arrow_down = findViewById(R.id.IV_close_recentcheck_view);
        iv_arrow_top = findViewById(R.id.IV_open_recentcheck_view);
        recents_bar_CL = findViewById(R.id.rtv2);
        iv_arrow_down.setVisibility(View.GONE);
        iv_arrow_top.setVisibility(View.VISIBLE);
        links_LV = findViewById(R.id.LV_list_score_recent_URLs);
        textView_norecents = findViewById(R.id.TV_recent_listView_empty);
        textView_norecents.setVisibility(View.GONE);
        score_n_analysis_CL = findViewById(R.id.main_view_score_n_analysis);
        //initialize the visibilities of Recents
        recents_bar_CL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrow_down_bool){
                    arrow_down_bool=false;
                    iv_arrow_down.setVisibility(View.VISIBLE);
                    iv_arrow_top.setVisibility(View.GONE);
                    textView_norecents.setVisibility(View.GONE);
                    links_LV.setVisibility(View.GONE);

                }else{
                    arrow_down_bool=true;
                    iv_arrow_down.setVisibility(View.GONE);
                    iv_arrow_top.setVisibility(View.VISIBLE);
                    textView_norecents.setVisibility(View.VISIBLE);//only when the List is Empty

                    String listVIEW_string = preferences.getString("SPtotalLinks_str", "");

                    if(listVIEW_string.length()==0){
                        links_LV.setVisibility(View.GONE);
                        textView_norecents.setVisibility(View.VISIBLE);
                    }else{
                        textView_norecents.setVisibility(View.GONE);
                        links_LV.setVisibility(View.VISIBLE);
                    }


                    ArrayList list;
                    ArrayAdapter adapter;
                    //for(int i =0)
                    String str_total_links = preferences.getString("SPtotalLinks_str", "");
                    char_total_links = str_total_links.toCharArray();
                    int_str_total_links_length=char_total_links.length;
                    //for Loop
                    for(int i=0;i<int_str_total_links_length;++i){
                        if(char_total_links[i]!=' '){
                            str_arr_links[in_arr_count]+=char_total_links[i];
                        }else{
                            in_arr_count+=1;
                        }
                    }//end of for loop
                    list = new ArrayList<>();

                    for(int i=in_arr_count-1; i>=0;--i){
                        list.add(str_arr_links[i]);
                    }
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                    links_LV.setAdapter(adapter);
                }
            }
        });
        //ListView insertion
        links_LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                // TODO Auto-generated method stub
                /* appending Happy with festival name */
                String value = (links_LV.getItemAtPosition(position)).toString();
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

                surl=value;
                if(surl.length()>14){
                    new Huirong().execute();
                }else{
                    Toast.makeText(getApplicationContext(),"URL INVALID", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getApplicationContext(), "please wait ..", Toast.LENGTH_SHORT).show();


            }
        });
//Ends ListView Insertion


        webView_krt = findViewById(R.id.webView_krt_fullScreen);
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();

        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),"No Internet Connection!", Toast.LENGTH_SHORT).show();
        }

        if(connected==true){
             WebSettings webSettings = webView_krt.getSettings();
            webSettings.setJavaScriptEnabled(true);

            webView_krt.loadUrl("https://ahrefs.com/keyword-generator");
        }
        else{
            Toast.makeText(getApplicationContext(), "No Internet Connectivity", Toast.LENGTH_SHORT).show();
        }
        webView_krt.setVisibility(View.GONE);

        //Left Top Most CL
        cl_leftVertBar =findViewById(R.id.leftTopMostCL);
        //Right Most CL Container for the Four LAyouts
        cl_rightMost_Contianer_4d4LAyouts = findViewById(R.id.rightTopMostCL);

        //Main Layouts
//        cl_main1 = findViewById(R.id.CL_right_main_seo_krt_sugs1);
        cl_scoreanalysis  = findViewById(R.id.CL_right_scorenanalysis6);
        cl_scoreLandingPAge =findViewById(R.id.CL_score_landing_page1);
        cl_compareSites_SEO =findViewById(R.id.CL_right_compare2);
        cl_brokenLinks = findViewById(R.id.CL_right_brokenLinks3);
        cl_settings = findViewById(R.id.CL_right_settings5);

        //Bottom Press Back Bar
        cl_press_back_bottom_bar =findViewById(R.id.press_back_iv_cv);

        //red background
        iv_wbckg1 = findViewById(R.id.iv_brown_icon1);
        iv_wbckg2 =findViewById(R.id.iv_brown_icon2);
        iv_wbckg3 =findViewById(R.id.iv_brown_icon3);
        //iv_wbckg4 =findViewById(R.id.iv_brown_icon4);
        iv_wbckg5 =findViewById(R.id.iv_brown_icon5);
        //white background
        iv_wthoutbckg1 = findViewById(R.id.iv_white_icon1);
        iv_wthoutbckg2 = findViewById(R.id.iv_white_icon2);
        iv_wthoutbckg3 = findViewById(R.id.iv_white_icon3);
        //iv_wthoutbckg4 = findViewById(R.id.iv_white_icon4);
        iv_wthoutbckg5 = findViewById(R.id.iv_white_icon5);

        cl_oneClick = findViewById(R.id.cl_opseo);//Check SEO
        cl_twoClick = findViewById(R.id.cl_links);//K R T
        cl_threeClick = findViewById(R.id.cl_compareWS);//compare websites
        //cl_fourClick = findViewById(R.id.cl_latestSCORE);
        cl_fiveClick = findViewById(R.id.cl_SETTINGS);

        //On App Open ---------------------------------------------------------------------------------------------------------------------------
        cl_press_back_bottom_bar.setVisibility(View.GONE);
        //cl_main1.setVisibility(View.GONE);
        cl_leftVertBar.setVisibility(View.VISIBLE);
        cl_rightMost_Contianer_4d4LAyouts.setVisibility(View.VISIBLE);
        //Right CL container 4 LAyouts
        //--------------------------------------------------

        cl_scoreLandingPAge.setVisibility(View.VISIBLE);
        cl_compareSites_SEO.setVisibility(View.GONE);
        cl_brokenLinks.setVisibility(View.GONE);
        cl_settings.setVisibility(View.GONE);
        cl_scoreanalysis.setVisibility(View.GONE);
        //Left Vertical ICons Container
        //--------------------------------------------------
        //1 -
        iv_wbckg1.setVisibility(View.INVISIBLE);
        iv_wthoutbckg1.setVisibility(View.VISIBLE);
        //2 -
        iv_wbckg2.setVisibility(View.INVISIBLE);
        iv_wthoutbckg2.setVisibility(View.VISIBLE);
        //3 -
        iv_wbckg3.setVisibility(View.INVISIBLE);
        iv_wthoutbckg3.setVisibility(View.VISIBLE);
        //4 -
        //iv_wbckg4.setVisibility(View.INVISIBLE);
       // iv_wthoutbckg4.setVisibility(View.VISIBLE);
        //5 -
        iv_wbckg5.setVisibility(View.INVISIBLE);
        iv_wthoutbckg5.setVisibility(View.VISIBLE);
        //Code for App Open Finishes HEre -----------------------------------------------------------------------------------------------




        int val_ori = preferences.getInt("sp_main_2_click_bottom_navigator", 11);
//        tabLayout=findViewById(R.id.tab_layout);
//        viewPager2=findViewById(R.id.view_pager2);

        editor.putInt("intent_viewPager", 2);
        editor.apply();

        String tab_text_1=getText(R.string.tab_text_1).toString();
        String tab_text_2=getText(R.string.tab_text_2).toString();
        String tab_text_3=getText(R.string.tab_text_3).toString();
//        tabLayout.addTab(tabLayout.newTab().setText( tab_text_1));
//        tabLayout.addTab(tabLayout.newTab().setText( tab_text_2));
//        tabLayout.addTab(tabLayout.newTab().setText( tab_text_3));
        FragmentManager fragmentManager = getSupportFragmentManager();
//        adapter = new Tab_Adapter(fragmentManager, getLifecycle());
//        viewPager2.setAdapter(adapter);
//        viewPager2.setOffscreenPageLimit(3);
        int intent_key_viewePagerNumber = preferences.getInt("intent_viewPager", 2);//0 is 1...., 1 is 2...., 2 is 3....
        if(intent_key_viewePagerNumber==1){
//            viewPager2.setCurrentItem(0);
//            tabLayout.selectTab(tabLayout.getTabAt(0));
        }else
        if(intent_key_viewePagerNumber==2){
//            viewPager2.setCurrentItem(1);
//            tabLayout.selectTab(tabLayout.getTabAt(1));
        }else {
//            viewPager2.setCurrentItem(2);
//            tabLayout.selectTab(tabLayout.getTabAt(2));
        }
 /*       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){

//                viewPager2.setCurrentItem(tab.getPosition());
                int tab_count = tab.getPosition();
                if(tab_count==0){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("intent_viewPager", 1);
                    editor.apply();
                }
                if(tab_count==1){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("intent_viewPager", 2);
                    editor.apply();
                }
                if(tab_count==2){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("intent_viewPager", 3);
                    editor.apply();
                }

//                question_tested_int_outside = preferences.getInt("sp_qc_n_o", 0);

//                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putInt("sp_latestscore", 3);
//                editor.putInt("sp_highscore", 4);
//                editor.apply();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab){

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab){

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageSelected(int position){
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        }
        );*/
        //Code for the Left Pane Icons & for the $ Right Layouts Display
        // -----------------------------------------------------------------------------------------
        final int[] click_two = {2};
        cl_oneClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1 -
                iv_wbckg1.setVisibility(View.VISIBLE);
                iv_wthoutbckg1.setVisibility(View.INVISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.INVISIBLE);
                iv_wthoutbckg2.setVisibility(View.VISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
               // iv_wbckg4.setVisibility(View.INVISIBLE);
               // iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);

                //Left container
                //Right Container
                //Bottom Bar Press BACK
                //MAin LAyout 1
                //4 Right Layouts
                //-------------------------------------------------------
                cl_leftVertBar.setVisibility(View.VISIBLE);
                cl_rightMost_Contianer_4d4LAyouts.setVisibility(View.VISIBLE);
                cl_press_back_bottom_bar.setVisibility(View.GONE);
                //cl_main1.setVisibility(View.GONE);

                cl_scoreLandingPAge.setVisibility(View.VISIBLE);
                cl_scoreanalysis.setVisibility(View.GONE);

                cl_compareSites_SEO.setVisibility(View.GONE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_settings.setVisibility(View.GONE);
                webView_krt.setVisibility(View.GONE);
            }
        });
        //Main LAyout HERE
        cl_twoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //1 -
                iv_wbckg1.setVisibility(View.INVISIBLE);
                iv_wthoutbckg1.setVisibility(View.VISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.VISIBLE);
                iv_wthoutbckg2.setVisibility(View.INVISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
               // iv_wbckg4.setVisibility(View.INVISIBLE);
                //iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);
                //On the KRT Tab
                //----------------------------------------------------
                cl_leftVertBar.setVisibility(View.GONE);
                cl_rightMost_Contianer_4d4LAyouts.setVisibility(View.GONE);
                cl_press_back_bottom_bar.setVisibility(View.VISIBLE);
                cl_scoreanalysis.setVisibility(View.GONE);

                //---------------------------------------------------
                //cl_main1.setVisibility(View.GONE);
                webView_krt.setVisibility(View.VISIBLE);




            }
        });
        //K R T
        cl_press_back_bottom_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if url is valid
                cl_press_back_bottom_bar.setVisibility(View.GONE);
                //cl_main1.setVisibility(View.GONE);
                cl_leftVertBar.setVisibility(View.VISIBLE);
                cl_rightMost_Contianer_4d4LAyouts.setVisibility(View.VISIBLE);
                //Right CL container 4 LAyouts
                //--------------------------------------------------
                cl_scoreLandingPAge.setVisibility(View.VISIBLE);
                cl_compareSites_SEO.setVisibility(View.GONE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_scoreanalysis.setVisibility(View.GONE);
                cl_settings.setVisibility(View.GONE);
                //Left Vertical ICons Container
                //--------------------------------------------------
                //1 -
                iv_wbckg1.setVisibility(View.VISIBLE);
                iv_wthoutbckg1.setVisibility(View.INVISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.INVISIBLE);
                iv_wthoutbckg2.setVisibility(View.VISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
                // iv_wbckg4.setVisibility(View.INVISIBLE);
                //iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);
                webView_krt.setVisibility(View.GONE);

            }
        });
        //Compare Sites
        cl_threeClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView_krt.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Feature coming in the Next Update", Toast.LENGTH_LONG).show();
                //Right CL container 4 LAyouts
                //--------------------------------------------------

                cl_scoreLandingPAge.setVisibility(View.VISIBLE);
                cl_compareSites_SEO.setVisibility(View.GONE);
                //cl_brokenLinks.setVisibility(View.VISIBLE);
                cl_settings.setVisibility(View.GONE);
                cl_scoreanalysis.setVisibility(View.GONE);


                //Left Vertical ICons Container
                //--------------------------------------------------
                //1 -
                iv_wbckg1.setVisibility(View.VISIBLE);
                iv_wthoutbckg1.setVisibility(View.INVISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.INVISIBLE);
                iv_wthoutbckg2.setVisibility(View.VISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
               // iv_wbckg4.setVisibility(View.INVISIBLE);
               // iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);
            }
        });
 /*       cl_fourClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webView_krt.setVisibility(View.GONE);
                //Right CL container 4 LAyouts
                //--------------------------------------------------

                cl_scoreLandingPAge.setVisibility(View.GONE);
                cl_compareSites_SEO.setVisibility(View.VISIBLE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_settings.setVisibility(View.GONE);

                //Left Vertical ICons Container
                //--------------------------------------------------
                //1 -
                iv_wbckg1.setVisibility(View.INVISIBLE);
                iv_wthoutbckg1.setVisibility(View.VISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.INVISIBLE);
                iv_wthoutbckg2.setVisibility(View.VISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
                iv_wbckg4.setVisibility(View.VISIBLE);
               // iv_wthoutbckg4.setVisibility(View.INVISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);
            }
        });*/
        //Settings
        cl_fiveClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView_krt.setVisibility(View.GONE);
                //1 -
                iv_wbckg1.setVisibility(View.INVISIBLE);
                iv_wthoutbckg1.setVisibility(View.VISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.INVISIBLE);
                iv_wthoutbckg2.setVisibility(View.VISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
               // iv_wbckg4.setVisibility(View.INVISIBLE);
               // iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.VISIBLE);
                iv_wthoutbckg5.setVisibility(View.INVISIBLE);

                //Right CL container 4 LAyouts
                //--------------------------------------------------

                cl_scoreLandingPAge.setVisibility(View.GONE);
                cl_compareSites_SEO.setVisibility(View.GONE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_settings.setVisibility(View.VISIBLE);
                cl_scoreanalysis.setVisibility(View.GONE);

            }
        });
        ConstraintLayout Back_SNA=findViewById(R.id.Back_SNA);
        //Search View
        ConstraintLayout searchnow = findViewById(R.id.cl_score_enter_enternow);

//Imported Contents From the FirstTab
//Start
        //EditText Value
        EditText et_searchbarvalue = findViewById(R.id.ET_ws_score);
        String str_etValue = et_searchbarvalue.getText().toString();
        surl = str_etValue;


//ListView on the MAinActivity
        if(arrow_down_bool){
            String listVIEW_string = preferences.getString("SPtotalLinks_str", "");
            if(listVIEW_string.length()>0){
                links_LV.setVisibility(View.VISIBLE);
                textView_norecents.setVisibility(View.GONE);
                links_LV.setAdapter(null);

                ArrayList list;
                ArrayAdapter adapter;
                String str_prev_total = preferences.getString("SPtotalLinks_str", "");

                space_plus_url = str_prev_total+" "+surl;
                editor.putString("SPtotalLinks_str",space_plus_url);
                editor.apply();

                //ListView insertion
                String str_total_links = preferences.getString("SPtotalLinks_str", "");
                char_total_links = str_total_links.toCharArray();
                int_str_total_links_length=char_total_links.length;
                //for Loop
                for(int i=0;i<int_str_total_links_length;++i){
                    if(char_total_links[i]!=' '){
                        str_arr_links[in_arr_count]+=char_total_links[i];
                    }else{
                        in_arr_count+=1;
                    }
                }//end of for loop
                list = new ArrayList<>();

                for(int i=in_arr_count-1; i>=0;--i){
                    list.add(str_arr_links[i]);
                }
                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                links_LV.setAdapter(adapter);

            }else{
                links_LV.setVisibility(View.GONE);
                textView_norecents.setVisibility(View.VISIBLE);
            }
        }
        /*

*/


//End

        searchnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_etValue = et_searchbarvalue.getText().toString();
                surl=str_etValue;
                textView_norecents.setVisibility(View.GONE);
                if(surl.length()>14){
                    new Huirong().execute();
                    Toast.makeText(getApplicationContext(), "please wait ..", Toast.LENGTH_SHORT).show();
                    links_LV.setAdapter(null);

                    ArrayList list;
                    ArrayAdapter adapter;
                    String str_prev_total = preferences.getString("SPtotalLinks_str", "");

                    space_plus_url = str_prev_total+" "+surl;
                    editor.putString("SPtotalLinks_str",space_plus_url);
                    editor.apply();
                    //ListView Insertion only when the ListView is Visibled!
                    if(arrow_down_bool)//i.e. when the listView is visibled
                    {
                        //ListView insertion
                        String str_total_links = preferences.getString("SPtotalLinks_str", "");
                        char_total_links = str_total_links.toCharArray();
                        int_str_total_links_length=char_total_links.length;
                        //for Loop
                        for(int i=0;i<int_str_total_links_length;++i){
                            if(char_total_links[i]!=' '){
                                str_arr_links[in_arr_count]+=char_total_links[i];
                            }else{
                                in_arr_count+=1;
                            }
                        }//end of for loop
                        list = new ArrayList<>();

                        for(int i=in_arr_count-1; i>=0;--i){
                            list.add(str_arr_links[i]);
                        }
                        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
                        links_LV.setAdapter(adapter);
                    }

/*

*/

                }else{
                    Toast.makeText(getApplicationContext(), "INVALID URL", Toast.LENGTH_SHORT).show();
                }


            }
        });
        Back_SNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if url is valid

                cl_press_back_bottom_bar.setVisibility(View.GONE);

                //cl_main1.setVisibility(View.GONE);
                cl_leftVertBar.setVisibility(View.VISIBLE);
                cl_rightMost_Contianer_4d4LAyouts.setVisibility(View.VISIBLE);
                //Right CL container 4 LAyouts
                //--------------------------------------------------
                cl_scoreLandingPAge.setVisibility(View.VISIBLE);
                cl_compareSites_SEO.setVisibility(View.GONE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_scoreanalysis.setVisibility(View.GONE);
                cl_settings.setVisibility(View.GONE);
                //Left Vertical ICons Container
                //--------------------------------------------------
                //1 -
                iv_wbckg1.setVisibility(View.VISIBLE);
                iv_wthoutbckg1.setVisibility(View.INVISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.INVISIBLE);
                iv_wthoutbckg2.setVisibility(View.VISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
                // iv_wbckg4.setVisibility(View.INVISIBLE);
                //iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);
                webView_krt.setVisibility(View.GONE);
            }
        });

        NestedScrollView parentscv, parsubscv, parentHTML_scv, parent_scv_score_speed, parent_scv_headers, parent_hyperlinks, parent_scv_imgALT, parent_scv_metaTAGS, parent_scv_domainAuthority, parent_scv_keywords, parent_scv_VIEWPORT;
        ScrollView  childscv , submainSCV, childSCV_headers_h1toh6, scv_child_hyperlinks, scv_child_imgALT, scv_child_metaTags, scv_child_keywords, scv_child_viewPORT;
        WebView scv_child_domainAuthority;

        parent_scv_VIEWPORT=findViewById(R.id.scv_scorenanalysis);
        scv_child_viewPORT=findViewById(R.id.scv_child_viewportSUGGESTIONS);
        parent_scv_keywords=findViewById(R.id.scv_scorenanalysis);
        scv_child_keywords=findViewById(R.id.scrollView_keywords);
        parent_scv_domainAuthority=findViewById(R.id.scv_scorenanalysis);
        scv_child_domainAuthority=findViewById(R.id.CLabhi4);
        parent_scv_metaTAGS=findViewById(R.id.scv_scorenanalysis);
        scv_child_metaTags=findViewById(R.id.scv_child_metaTAGS);
        parent_scv_imgALT=findViewById(R.id.scv_scorenanalysis);
        scv_child_imgALT=findViewById(R.id.scv_child_imagesALT);
        parent_hyperlinks=findViewById(R.id.scv_scorenanalysis);
        scv_child_hyperlinks=findViewById(R.id.scv_child_hyperlinks);
        parent_scv_headers=findViewById(R.id.scv_scorenanalysis);
        childSCV_headers_h1toh6=findViewById(R.id.scv_headers_subchild);
        parentHTML_scv=findViewById(R.id.scv_scorenanalysis);
        parentscv = findViewById(R.id.scv_scorenanalysis);
         parsubscv = findViewById(R.id.scv_scorenanalysis);

        submainSCV = findViewById(R.id.overview_scv);
        parent_scv_score_speed=findViewById(R.id.scv_scorenanalysis);
        ScrollView sub_scv_recommendedspeed = findViewById(R.id.scv_recommended_speed);
        ScrollView scvchild_html = findViewById(R.id.scv_html);

        //ViewPort
        parent_scv_VIEWPORT.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_child_viewportSUGGESTIONS).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scv_child_viewPORT.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //Keywords
        parent_scv_keywords.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.CLabhi4).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scv_child_keywords.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //Domain Authority
        parent_scv_domainAuthority.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.CLabhi4).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scv_child_domainAuthority.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //MetaTAGS
        parent_scv_metaTAGS.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_child_metaTAGS).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scv_child_metaTags.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //Images ALT
        parent_scv_imgALT.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_child_imagesALT).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scv_child_imgALT.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        //Hyperlinks
        parent_hyperlinks.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_child_hyperlinks).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scv_child_hyperlinks.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        //Headers H1 to H6 - ScrollView
        parent_scv_score_speed.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_headers_subchild).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        childSCV_headers_h1toh6.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        //speed score parent
        parent_scv_score_speed.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_recommended_speed).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        sub_scv_recommendedspeed.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        parentHTML_scv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.scv_html).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        scvchild_html.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        parsubscv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.submain_scv_layout).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        submainSCV.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event)
            {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        //Big Layout Container for the IV/TV




        HIGHabove1 =  findViewById(R.id.HIGHabove1);
        HIGHabove2 =  findViewById(R.id.HIGHabove2);
        HIGHabove3 =  findViewById(R.id.HIGHabove3);
        HIGHabove4 =  findViewById(R.id.HIGHabove4);
        HIGHabove5 =  findViewById(R.id.HIGHabove5);
        HIGHabove6 =  findViewById(R.id.HIGHabove6);
        HIGHabove7 =  findViewById(R.id.HIGHabove7);

        CLabove0 = findViewById(R.id.CLabhi0);
        CLabove1 = findViewById(R.id.CLabhi1);
        CLabove2 = findViewById(R.id.CLabhi2);
        CLabove3 = findViewById(R.id.CLabhi3);
        CLabove4 = findViewById(R.id.CLabhi4);
        CLabove5 = findViewById(R.id.CLabhi5);
        CLabove6 = findViewById(R.id.CLabhi6);
        CLabove7 = findViewById(R.id.CLabhi7);

        HIGHabove0.setVisibility(View.VISIBLE);
        HIGHabove1.setVisibility(View.GONE);
        CLabove0.setVisibility(View.GONE);
        CLabove1.setVisibility(View.VISIBLE);
        CLabove2.setVisibility(View.GONE);
        CLabove3.setVisibility(View.GONE);
        CLabove4.setVisibility(View.GONE);
        CLabove5.setVisibility(View.GONE);
        CLabove6.setVisibility(View.GONE);
        CLabove7.setVisibility(View.GONE);
        final String[] str_redspeed = new String[1];
        final String[] str_scoremarkintext = new String[1];
        String str_scoreinSECONDS;
        String str_scoreinMILLIS;
        count[0] = 0;



        //Score
        HIGHabove0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int_score_general=0;
                int_score_content=0;
                int_score_speed=0;
                int_score_structure=0;

                WebView webView_checkSCORE = findViewById(R.id.webView_checkSCORE);
                webView_checkSCORE.getSettings().setJavaScriptEnabled(true);
                webView_checkSCORE.setWebViewClient(new WebViewClient());
                Toast.makeText(getApplicationContext(),"LOADING.\tPlease Be Patient", Toast.LENGTH_SHORT).show();
                long startTime = 0;
                final long[] timeToLoad = new long[1];
                long millis;
                final long[] doneTime = new long[1];
                final float[] seconds = new float[1];
                long finalStartTime = 0;
                final long[] finalStartTime1 = {finalStartTime};

                final String[] str_millis = {""};
                webView_checkSCORE.loadUrl(surl);
                finalStartTime1[0] = System.currentTimeMillis();
                webView_checkSCORE.setWebViewClient(new WebViewClient() {

                    public void onPageStarted(WebView view, String url) {

                        Toast.makeText(getApplicationContext(), "Loading Started", Toast.LENGTH_SHORT).show();
                    }

                    public void onPageFinished(WebView view, String url) {
                        doneTime[0] = System.currentTimeMillis()-finalStartTime1[0];
                        final_speed_score_in_millis=doneTime[0];
                        //webView_siteLoadSPEED.setVisibility(View.GONE);
                        str_millis[0] = String.valueOf(doneTime[0]);
                        seconds[0] = (float)doneTime[0]/1000 ;
                        String str_seconds = String.valueOf(seconds[0]);
                        final_speed_score_percentage=doneTime[0];
                        //tv_speedSECONDS.setText(str_seconds);
                        //tv_speedMILLIS.setText("~ "+str_millis[0]+" millis");
                        if(doneTime[0]>0 && doneTime[0]<1990){
                            //perfect
                            string_final_spee_score_remarks="Perfect Load Speed";
                            //string_final_spee_score_remarks ="Your site took "+str_seconds+" seconds to Load.\nYour site is optimised for Fast Loading.";
                        }else
                        if(doneTime[0]>1991 && doneTime[0]<3990){
                            //fair
                            string_final_spee_score_remarks="Fair Load Speed";
                            //string_final_spee_score_remarks ="Your site took "+str_seconds+" seconds to Load.\nYour site is fairly optimised. Needs compression in Media Files(Images or Videos, etc.) sizes.";

                        }else
                        if(doneTime[0]>3991){
                            //poor
                            string_final_spee_score_remarks ="Poor Load Speed";
                            //string_final_spee_score_remarks ="Your site took "+str_seconds+" seconds to Load.\nYour site is poorly optimised. Consider compression in Media Files(images, videso, etc.) sizes. Take the Recommended Actions below, on your site.";

                        }

                        //tv_scoreDESIGNATION.setText(str_scoremarkintext[0]);
                        //tv_red.setText(str_redspeed[0]);
                        //tv_scoreDESIGNATION.setText(str_scoremarkintext[0]);
                        // Toast.makeText(getApplicationContext(), "Loading took "+str_millis+" seconds!",Toast.LENGTH_SHORT).show();
                        webView_checkSCORE.setVisibility(View.GONE);
                        new SiteLS_asyncCLASS().execute();
                    }
                });

            }
        });
        //Content
        HIGHabove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.VISIBLE);
                CLabove2.setVisibility(View.GONE);
                CLabove3.setVisibility(View.GONE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.GONE);
                CLabove6.setVisibility(View.GONE);
                CLabove7.setVisibility(View.GONE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.GONE);
                HIGHabove2.setVisibility(View.VISIBLE);
                HIGHabove3.setVisibility(View.VISIBLE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.VISIBLE);
                HIGHabove6.setVisibility(View.VISIBLE);
                HIGHabove7.setVisibility(View.VISIBLE);
            }
        });
        //Site Load Speed
        HIGHabove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.GONE);
                CLabove2.setVisibility(View.VISIBLE);
                CLabove3.setVisibility(View.GONE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.GONE);
                CLabove6.setVisibility(View.GONE);
                CLabove7.setVisibility(View.GONE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.VISIBLE);
                HIGHabove2.setVisibility(View.GONE);
                HIGHabove3.setVisibility(View.VISIBLE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.VISIBLE);
                HIGHabove6.setVisibility(View.VISIBLE);
                HIGHabove7.setVisibility(View.VISIBLE);
                TextView tv_red, tv_scoreDESIGNATION, tv_speedMILLIS, tv_speedSECONDS;
                tv_red = findViewById(R.id.tv_sample);
                tv_speedSECONDS = findViewById(R.id.score_siteloadduration_1st);
                tv_speedMILLIS = findViewById(R.id.score_siteloadduration_2nd);
                tv_scoreDESIGNATION=findViewById(R.id.tv_score_speed);

                WebView webView_siteLoadSPEED = findViewById(R.id.webView_forSiteSpeedTest);
                webView_siteLoadSPEED.getSettings().setJavaScriptEnabled(true);
                webView_siteLoadSPEED.setWebViewClient(new WebViewClient());
                long startTime = 0;
                final long[] timeToLoad = new long[1];
                long millis;
                final long[] doneTime = new long[1];
                final float[] seconds = new float[1];
                long finalStartTime = 0;
                final long[] finalStartTime1 = {finalStartTime};

                final String[] str_millis = {""};
                webView_siteLoadSPEED.loadUrl("https://www.google.com/");
                finalStartTime1[0] = System.currentTimeMillis();
                webView_siteLoadSPEED.setWebViewClient(new WebViewClient() {

                    public void onPageStarted(WebView view, String url) {

                        Toast.makeText(getApplicationContext(), "Loading Started", Toast.LENGTH_SHORT).show();
                    }

                    public void onPageFinished(WebView view, String url) {
                        doneTime[0] = System.currentTimeMillis()-finalStartTime1[0];
                        //webView_siteLoadSPEED.setVisibility(View.GONE);
                        str_millis[0] = String.valueOf(doneTime[0]);
                        seconds[0] = (float)doneTime[0]/1000 ;
                        String str_seconds = String.valueOf(seconds[0]);

                        tv_speedSECONDS.setText(str_seconds);
                        tv_speedMILLIS.setText("~ "+str_millis[0]+" millis");
                        if(doneTime[0]>0 && doneTime[0]<1990){
                            //perfect
                            str_scoremarkintext[0]="Perfect Load Speed";
                            str_redspeed[0] ="Your site took "+str_seconds+" seconds to Load.\nYour site is optimised for Fast Loading.";
                        }else
                        if(doneTime[0]>1991 && doneTime[0]<3990){
                            //fair
                            str_scoremarkintext[0]="Fair Load Speed";
                            str_redspeed[0] ="Your site took "+str_seconds+" seconds to Load.\nYour site is fairly optimised. Needs compression in Media Files(Images or Videos, etc.) sizes.";

                        }else
                        if(doneTime[0]>3991){
                            //poor
                            str_scoremarkintext[0]="Poor Load Speed";
                            str_redspeed[0] ="Your site took "+str_seconds+" seconds to Load.\nYour site is poorly optimised. Consider compression in Media Files(images, videso, etc.) sizes. Take the Recommended Actions below, on your site.";

                        }

                        tv_scoreDESIGNATION.setText(str_scoremarkintext[0]);
                        tv_red.setText(str_redspeed[0]);
                        tv_scoreDESIGNATION.setText(str_scoremarkintext[0]);
                        // Toast.makeText(getApplicationContext(), "Loading took "+str_millis+" seconds!",Toast.LENGTH_SHORT).show();
                        webView_siteLoadSPEED.setVisibility(View.GONE);
                    }
                });





            }
        });
        //HTML Source
        HIGHabove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new    HTML_asyncCLASS().execute();
            }
        });
        //Doamin Authority
        HIGHabove4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView_domainAuthority.getSettings().setJavaScriptEnabled(true);
                webView_domainAuthority.loadUrl("https://moz.com/domain-analysis");

                new DA_domainAuthority_asyncCLASS().execute();
            }
        });
        //Meta Tags
        HIGHabove5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.GONE);
                CLabove2.setVisibility(View.GONE);
                CLabove3.setVisibility(View.GONE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.VISIBLE);
                CLabove6.setVisibility(View.GONE);
                CLabove7.setVisibility(View.GONE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.VISIBLE);
                HIGHabove2.setVisibility(View.VISIBLE);
                HIGHabove3.setVisibility(View.VISIBLE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.GONE);
                HIGHabove6.setVisibility(View.VISIBLE);
                HIGHabove7.setVisibility(View.VISIBLE);
            }
        });
        //Keywords
        HIGHabove6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.GONE);
                CLabove2.setVisibility(View.GONE);
                CLabove3.setVisibility(View.GONE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.GONE);
                CLabove6.setVisibility(View.VISIBLE);
                CLabove7.setVisibility(View.GONE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.VISIBLE);
                HIGHabove2.setVisibility(View.VISIBLE);
                HIGHabove3.setVisibility(View.VISIBLE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.VISIBLE);
                HIGHabove6.setVisibility(View.GONE);
                HIGHabove7.setVisibility(View.VISIBLE);
            }
        });
        //View Port
        HIGHabove7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.GONE);
                CLabove2.setVisibility(View.GONE);
                CLabove3.setVisibility(View.GONE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.GONE);
                CLabove6.setVisibility(View.GONE);
                CLabove7.setVisibility(View.VISIBLE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.VISIBLE);
                HIGHabove2.setVisibility(View.VISIBLE);
                HIGHabove3.setVisibility(View.VISIBLE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.VISIBLE);
                HIGHabove6.setVisibility(View.VISIBLE);
                HIGHabove7.setVisibility(View.GONE);
            }
        });




        //Highlighters for TV
        ConstraintLayout HIGHabu1, HIGHabu2, HIGHabu3, HIGHabu4, HIGHabu5, HIGHabu6, HIGHabu7;
        //Big Layout Container for the TV
        ConstraintLayout CLabu1, CLabu2, CLabu3, CLabu4, CLabu5, CLabu6, CLabu7;

        HIGHabu1 = findViewById(R.id.HIGHabu1);
        HIGHabu2 = findViewById(R.id.HIGHabu2);
        HIGHabu3 = findViewById(R.id.HIGHabu3);
        HIGHabu4 = findViewById(R.id.HIGHabu4);
        HIGHabu5 = findViewById(R.id.HIGHabu5);
        HIGHabu6 = findViewById(R.id.HIGHabu6);
        HIGHabu7 = findViewById(R.id.HIGHabu7);

        HIGHabu1.setVisibility(View.GONE);
        HIGHabu2.setVisibility(View.VISIBLE);
        HIGHabu3.setVisibility(View.VISIBLE);
        HIGHabu4.setVisibility(View.VISIBLE);
        HIGHabu5.setVisibility(View.VISIBLE);
        HIGHabu6.setVisibility(View.VISIBLE);
        HIGHabu7.setVisibility(View.VISIBLE);

        CLabu1= findViewById(R.id.opseo_overview);//Overview
        CLabu2=findViewById(R.id.opseo_headers);//Headers
        CLabu3=findViewById(R.id.opseo_body);//Body
        CLabu4=findViewById(R.id.opseo_hyperlinks);//HyperLinks
        CLabu5=findViewById(R.id.opseo_imagesoralt);//Images/Alt
        CLabu6 = findViewById(R.id.opseo_rellinkcanonical);//Rel Link Canonical Tag
        CLabu7 = findViewById(R.id.opseo_favicon);//Favicon

        CLabu1.setVisibility(View.VISIBLE);
        CLabu2.setVisibility(View.GONE);
        CLabu3.setVisibility(View.GONE);
        CLabu4.setVisibility(View.GONE);
        CLabu5.setVisibility(View.GONE);
        CLabu6.setVisibility(View.GONE);
        CLabu7.setVisibility(View.GONE);

        HIGHabu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.GONE);
                HIGHabu2.setVisibility(View.VISIBLE);
                HIGHabu3.setVisibility(View.VISIBLE);
                HIGHabu4.setVisibility(View.VISIBLE);
                HIGHabu5.setVisibility(View.VISIBLE);
                HIGHabu6.setVisibility(View.VISIBLE);
                HIGHabu7.setVisibility(View.VISIBLE);
                CLabu1.setVisibility(View.VISIBLE);
                CLabu2.setVisibility(View.GONE);
                CLabu3.setVisibility(View.GONE);
                CLabu4.setVisibility(View.GONE);
                CLabu5.setVisibility(View.GONE);
                CLabu6.setVisibility(View.GONE);
                CLabu7.setVisibility(View.GONE);
            }
        });
        HIGHabu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.VISIBLE);
                HIGHabu2.setVisibility(View.GONE);
                HIGHabu3.setVisibility(View.VISIBLE);
                HIGHabu4.setVisibility(View.VISIBLE);
                HIGHabu5.setVisibility(View.VISIBLE);
                HIGHabu6.setVisibility(View.VISIBLE);
                HIGHabu7.setVisibility(View.VISIBLE);
                CLabu1.setVisibility(View.GONE);
                CLabu2.setVisibility(View.VISIBLE);
                CLabu3.setVisibility(View.GONE);
                CLabu4.setVisibility(View.GONE);
                CLabu5.setVisibility(View.GONE);
                CLabu6.setVisibility(View.GONE);
                CLabu7.setVisibility(View.GONE);
            }
        });
        HIGHabu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.VISIBLE);
                HIGHabu2.setVisibility(View.VISIBLE);
                HIGHabu3.setVisibility(View.GONE);
                HIGHabu4.setVisibility(View.VISIBLE);
                HIGHabu5.setVisibility(View.VISIBLE);
                HIGHabu6.setVisibility(View.VISIBLE);
                HIGHabu7.setVisibility(View.VISIBLE);
                CLabu1.setVisibility(View.GONE);
                CLabu2.setVisibility(View.GONE);
                CLabu3.setVisibility(View.VISIBLE);
                CLabu4.setVisibility(View.GONE);
                CLabu5.setVisibility(View.GONE);
                CLabu6.setVisibility(View.GONE);
                CLabu7.setVisibility(View.GONE);
            }
        });
        HIGHabu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.VISIBLE);
                HIGHabu2.setVisibility(View.VISIBLE);
                HIGHabu3.setVisibility(View.VISIBLE);
                HIGHabu4.setVisibility(View.GONE);
                HIGHabu5.setVisibility(View.VISIBLE);
                HIGHabu6.setVisibility(View.VISIBLE);
                HIGHabu7.setVisibility(View.VISIBLE);
                CLabu1.setVisibility(View.GONE);
                CLabu2.setVisibility(View.GONE);
                CLabu3.setVisibility(View.GONE);
                CLabu4.setVisibility(View.VISIBLE);
                CLabu5.setVisibility(View.GONE);
                CLabu6.setVisibility(View.GONE);
                CLabu7.setVisibility(View.GONE);
            }
        });
        HIGHabu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.VISIBLE);
                HIGHabu2.setVisibility(View.VISIBLE);
                HIGHabu3.setVisibility(View.VISIBLE);
                HIGHabu4.setVisibility(View.VISIBLE);
                HIGHabu5.setVisibility(View.GONE);
                HIGHabu6.setVisibility(View.VISIBLE);
                HIGHabu7.setVisibility(View.VISIBLE);
                CLabu1.setVisibility(View.GONE);
                CLabu2.setVisibility(View.GONE);
                CLabu3.setVisibility(View.GONE);
                CLabu4.setVisibility(View.GONE);
                CLabu5.setVisibility(View.VISIBLE);
                CLabu6.setVisibility(View.GONE);
                CLabu7.setVisibility(View.GONE);
            }
        });
        HIGHabu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.GONE);
                HIGHabu2.setVisibility(View.VISIBLE);
                HIGHabu3.setVisibility(View.VISIBLE);
                HIGHabu4.setVisibility(View.VISIBLE);
                HIGHabu5.setVisibility(View.VISIBLE);
                HIGHabu6.setVisibility(View.GONE);
                HIGHabu7.setVisibility(View.VISIBLE);
                CLabu1.setVisibility(View.GONE);
                CLabu2.setVisibility(View.GONE);
                CLabu3.setVisibility(View.GONE);
                CLabu4.setVisibility(View.GONE);
                CLabu5.setVisibility(View.GONE);
                CLabu6.setVisibility(View.VISIBLE);
                CLabu7.setVisibility(View.GONE);
            }
        });
        HIGHabu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HIGHabu1.setVisibility(View.GONE);
                HIGHabu2.setVisibility(View.VISIBLE);
                HIGHabu3.setVisibility(View.VISIBLE);
                HIGHabu4.setVisibility(View.VISIBLE);
                HIGHabu5.setVisibility(View.VISIBLE);
                HIGHabu6.setVisibility(View.VISIBLE);
                HIGHabu7.setVisibility(View.GONE);
                CLabu1.setVisibility(View.GONE);
                CLabu2.setVisibility(View.GONE);
                CLabu3.setVisibility(View.GONE);
                CLabu4.setVisibility(View.GONE);
                CLabu5.setVisibility(View.GONE);
                CLabu6.setVisibility(View.GONE);
                CLabu7.setVisibility(View.VISIBLE);
            }
        });



    }

    private class Huirong extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(true);
            progressDialog.show();
            count[0] = 0;

        }
        @Override
        protected Void doInBackground(Void... params) {

            //URL section
            //HTML source code section
            surl=surl.trim();

            for(int i=0;i<500;++i){
                surl_sd_a[i]="";
                title_keywords_a[i]="";
                h1_total_a[i]="";
                h2_total_a[i]="";
                h3_total_a[i]="";
                h4_total_a[i]="";
                h5_total_a[i]="";
                h6_total_a[i]="";
                img_alt_value[i]="";
                img_res_value[i]="";
                img_linksrc_value[i]="";
                img_alt_bool[i]=false;
            }
            for(int i=0; i<2000; ++i){
                highlighted_text_str_a[i]="";
                highlightedLink_str_a[i]="";
            }
            html_string="";//2
            keywords_report="";//8
            page_favicon_report="";//9 , desc, robots, viewport, rel canonical link tag, author
            body_report="";//5
            href_strings_report="";//6
            url_valid_on_bool=false;
            website_secured_on_bool=false;
            key_pos=0;
            no_of_dots=0;
            keyLastSecond='a';


            h1_report="";
            h2_report="";
            h3_report="";
            h4_report="";
            h5_report="";
            h6_report="";
            surl_report="";
            string_url_editText="";

            title_string="";
            h1_bool=false;
            h2_bool=false;
            h3_bool=false;
            h4_bool=false;
            h5_bool=false;
            h6_bool=false;
            h1_twords=0;
            h2_twords=0;
            h3_twords=0;
            h4_twords=0;
            h5_twords=0;
            h6_twords=0;
            h1_tws=0;h1_size=0;p_tags_size=0;
            h2_tws=0;h2_size=0;h1_tags_size=0;
            h3_tws=0;h3_size=0;h2_tags_size=0;
            h4_tws=0;h4_size=0;h3_tags_size=0;
            h5_tws=0;h5_size=0;h4_tags_size=0;img_tags_size=0;
            h6_tws=0;h6_size=0;h5_tags_size=0;h6_tags_size=0;
            h1_char_count=0;h1_string="";h1_string_ftc="";
            h2_char_count=0;h2_string="";h2_string_ftc="";
            h3_char_count=0;h3_string="";h3_string_ftc="";
            h4_char_count=0;h4_string="";h4_string_ftc="";
            h5_char_count=0;h5_string="";h5_string_ftc="";
            h6_char_count=0;h6_string="";h6_string_ftc="";
            headers_report_h1_h6="";total_keywords_count=0;




            img_count_size=0;
            img_alt_count_size=0;

            title_report="";//3
            img_report_string="";//7
            headers_report_h1_h6="";//4
            meta_description_string=""; //14
            meta_robots_string=""; //15
            meta_keywords_string="";//19
            meta_author_string="";//18
            meta_viewport_string=""; //16
            rel_canonical_report="";
            rel_canonical="";
            meta__tags_total=0;
            link_text_count_size_numbers=0;
            links_count=0;
            keywords_report="";

            rel_canonical_report_string="";//17
            page_favicon_report="";
            ip_address_str="";

            meta_description_tags_size=0;
            meta_robots_size=0;
            meta_view_port_size=0;
            link_rel_canonical_tag_size=0;
            meta_author_size=0;
            meta_keywords_size=0;

            int url_char_count = 0;
            int url_word_count = 0;
            int url_ws_count = 0;
            int no_of_slashes_inURL = 0;
            int sd_pos_fs = 0;

            surl_protocol = "";
            surl_subDomain = "";
            surl_rootDomain = "";
            surl_topLevelDomain = "";
            //head
            //content
            strovvhead_url="You don't have a Fair URL Structure";
            strovvbody_url="NA";

            strovvhead_Links="Internal Links doesn't Exist!";
            strovvbody_Links="NA";

            strovvhead_title="Title doesn't Exist!";
            strovvbody_title="NA";

            strovvhead_H1="Header H1 doesn't Exist!";
            strovvbody_H1="NA";

            strovvhead_H2="Header H2 doesn't Exist!";
            strovvbody_H2="NA";

            strovvhead_H3="Header H3 doesn't Exist!";
            strovvbody_H3="NA";

            strovvhead_H4="Header H4 doesn't Exist!";
            strovvbody_H4="NA";

            strovvhead_H5="Header H5 doesn't Exist!";
            strovvbody_H5="NA";

            strovvhead_H6="Header H6 doesn't Exist!";
            strovvbody_H6="NA";

            strovvhead_Images="Images doesn't Exist for your Site!";
            strovvbody_Images="NA";

            strovvhead_metaDescrpsn="Meta Description doesn't Exist!";
            strovvbody_metaDescrpsn="NA";

            strovvhead_MetaKeywords="Meta Keywords doesn't Exist!";
            strovvbody_MetaKeywords="NA";

            strovvhead_MEtaAuthor="Meta Keywords doesn't Exist!";
            strovvbody_MEtaAuthor="NA";

            strovvhead_ViewPort="MEta View Port doesn't Exist!";
            strovvbody_ViewPort="NA";

            strovvhead_Robots="Meta Robots doesn't Exist!";
            strovvbody_Robots="NA";

            strovvhead_RelLinkCanonical="REL LINK CANONICAL tag doesn't Exist!";
            strovvbody_RelLinkCanonical="NA";






            no_of_subDirectories_inURL = 0;
            char[] ch_array_url = surl.toCharArray();
            url_char_count = surl.length();

            if(url_char_count==0){
                url_valid_on_bool=false;
            }
            //* no. of slashes
            for (int i = 0; i < url_char_count; ++i) {
                if (ch_array_url[i] == '/') {
                    no_of_slashes_inURL += 1;
                }
            }
            //2.5. URL is secured or not:   contains "s" or not
            if (ch_array_url[4] == 's') {
                website_secured_on_bool = true;
                surl_protocol = "https://";
                sd_pos_fs = 8;
            } else {
                website_secured_on_bool = false;
                surl_protocol = "http://";
                sd_pos_fs = 7;
            }
            //3. url valid or not
            no_of_dots = 0;
            if (url_char_count <= 9) {
                url_valid_on_bool = false;
            } else {
                for (int i = 0; i < url_char_count; ++i) {
                    if (ch_array_url[i] == '.') {
                        no_of_dots += 1;
                    }
                }
                if (no_of_dots <= 0) {
                    url_valid_on_bool = false;
                } else
                {
                    if (ch_array_url[0] != 'h') {
                        url_valid_on_bool = false;
                    } else {
                        url_valid_on_bool = true;
                    }
                }

            }
            if (url_valid_on_bool == true) {
//4. subDomain
                boolean h = false;
                while (sd_pos_fs != url_char_count) {
                    if (ch_array_url[sd_pos_fs] != '.') {
                        surl_subDomain += ch_array_url[sd_pos_fs];
                    } else {
                        surl_subDomain += ch_array_url[sd_pos_fs];
                        break;
                    }
                    sd_pos_fs += 1;
                }
                sd_pos_fs += 1;
//5. root Domain
                while (sd_pos_fs != url_char_count) {
                    if (no_of_dots >= 2) {
                        if (ch_array_url[sd_pos_fs] != '.') {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                        } else {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                            break;
                        }
                    }
                    if (no_of_dots == 1) {
                        if (ch_array_url[sd_pos_fs] != '/') {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                        } else {
                            surl_rootDomain += ch_array_url[sd_pos_fs];
                            break;
                        }
                    }


                    sd_pos_fs += 1;
                }
//6. top level domain
                key_pos = 0;
                while (sd_pos_fs != url_char_count) {
                    if (ch_array_url[sd_pos_fs] != '/') {
                        surl_topLevelDomain += ch_array_url[sd_pos_fs];
                    } else {
                        surl_topLevelDomain += ch_array_url[sd_pos_fs];

                        keyLastSecond = ch_array_url[(sd_pos_fs - 1)];
                        if (sd_pos_fs + 1 <= url_char_count) {
                            key_pos = sd_pos_fs + 1;
                        }

                        break;
                    }
                    sd_pos_fs += 1;

                }
//7. categories, or subdirectories, or surl_sd_a[20]
                int k = 0;
                boolean hit_second_dot_q = false;
                for (int i = 0; i < url_char_count; ++i) {
                    if (ch_array_url[i] == '.') {
                        k = k + 1;
                        if (k == 2) {
                            hit_second_dot_q = true;
                        }
                    }
                    if (hit_second_dot_q == true) {
                        if (ch_array_url[i] == '/') {
                            key_pos = i + 1;
                            break;
                        }
                    }
                }
                //* no of sub directories
                if (ch_array_url[url_char_count - 1] == '/') {
                    char st = ch_array_url[url_char_count - 2];
                    if (keyLastSecond == st) {
                        no_of_subDirectories_inURL = 0;
                    } else {
                        no_of_subDirectories_inURL = no_of_slashes_inURL - 3;
                    }

                } else {
                    char st = ch_array_url[url_char_count - 2];
                    if (keyLastSecond == st) {
                        no_of_subDirectories_inURL = 0;
                    } else {
                        no_of_subDirectories_inURL = no_of_slashes_inURL - 2;
                    }
                }


                //start subDirectories code
                int i = 0;
                boolean jump_directory_bool = false;
                if (key_pos != 0) {
                    while (key_pos < url_char_count) {
                        if (ch_array_url[key_pos] != '/') {
                            surl_sd_a[i] += ch_array_url[key_pos];
                        } else {
                            surl_sd_a[i] += ch_array_url[key_pos];
                            i = i + 1;
                            if ((i - 1) == no_of_subDirectories_inURL - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }
                }
            }
            if (url_valid_on_bool == false) {
                surl_report = "1. URL is invalid. Try removing spaces from both the Ends of the URL. \n\n";
            } else {
                surl_report = "URL:\n---------------------------------------------------------------------------------------------\n" + surl + "\n---------------------------------------------------------------------------------------------\n\n1. URL structure is valid\n\n";
                if (website_secured_on_bool == false) {
                    surl_report = surl_report + "2. Site is not secured. Uses \"http\" in place of \"http\" as a scheme. \n\n";
                } else {
                    surl_report = surl_report + "2. Site is secured. Uses \"https\" as a scheme. \n\n";
                }
                surl_report = surl_report + "3. Site Architecture:\n\t- SCHEME: \t\t" + surl_protocol + "\n\t- SUB-DOMAIN: \t\t" + surl_subDomain + "\n\t- ROOT-DOMAIN: \t\t" + surl_rootDomain + "\n\t- TOP LEVEL-DOMAIN: \t\t" + surl_topLevelDomain;
                if (no_of_subDirectories_inURL == 0) {
                    surl_report = surl_report + "\n\n\t- Sub Directory(s): UNAVAILABLE !\n";
                } else {
                    surl_report = surl_report + "\n\n\t- Sub Directory(s): AVAILABLE !\n";
                    surl_report = surl_report + "\n\n\t- Sub Directories:-\t Counts to " + no_of_subDirectories_inURL + " in numbers";

                    for (int k = 0; k < no_of_subDirectories_inURL; ++k) {
                        surl_report = surl_report + "\n\t- SubDirectory_" + (k + 1) + ":\t " + surl_sd_a[k];
                    }
                }
                surl_report = surl_report + "\n\n4. URL/Site IP Address: " + ip_address_str;

            }
//URL Structure
            strovvhead_url=surl;
            strovvbody_url=surl_report;

            if (url_valid_on_bool == true) {
                try {
                    bool_ovv1urlreport=true;
                    html_string = Jsoup.connect(surl).get().html();
                    if(html_string==""){
                        url_valid_on_bool=false;
                    }
                } catch (IOException e) {
                    html_string = "Copy paste the Full URL. \nYou can use this tool as an enhancer in your SEO process. \nThis Application's Algorithm knows what you're up to.\n\nThe previous URL analysis was designed to interest you.\nThis HTML analysis section will tell the truth whether the URL is valid or not, that you can't really extract a HTML source code of a site/page with a \"not-so working\" URL.";
                    url_valid_on_bool=false;
                    bool_ovv1urlreport=false;
                }
            }


//Title Section
            title_ws_count = 0;
            title_char_count = 0;
            title_word_count = 0;
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                title_string = document.title();
                char[] ch_array_title = title_string.toCharArray();
                title_char_count = title_string.length();
                if(title_char_count>0){
                    bool_ovv2title=true;
                }else{
                    bool_ovv2title=false;
                }
                for (int i = 0; i < title_char_count; ++i) {
                    if (ch_array_title[i] == ' ') {
                        title_ws_count += 1;
                    }
                }
                if (ch_array_title[0] == ' ') {

                    if (ch_array_title[title_char_count - 1] == ' ') {
                        if (title_ws_count == 2) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 2) {
                            title_word_count = title_ws_count - 1;
                        }
                    } else {
                        if (title_ws_count == 1) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 1) {
                            title_word_count = title_ws_count;
                        }
                    }
                } else {
                    if (ch_array_title[title_char_count - 1] == ' ') {
                        if (title_ws_count == 1) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 1) {
                            title_word_count = title_ws_count;
                        }
                    } else {
                        if (title_ws_count == 0) {
                            title_word_count = 1;
                        }
                        if (title_ws_count > 0) {
                            title_word_count = title_ws_count + 1;
                        }
                    }
                }

                title_report = "";
                title_report = "Title: " + title_string + "\n\n1. Length:\n\t\t- " + title_char_count + " Characters\n\t\t- or, " + title_word_count + " words & " + title_ws_count + " whitespaces\n\n2. Keywords:";

                //Sub directories code
                //start subDirectories code
                //key_pos code
                int hello;
                for (int i = 0; i < title_char_count; ++i) {
                    if (ch_array_title[i] != ' ') {
                        key_pos = i;
                        hello = i;
                        break;
                    }
                }
                title_keywords_a[0] = "";
                title_keywords_a[1] = "";
                title_keywords_a[2] = "";
                title_keywords_a[3] = "";
                title_keywords_a[4] = "";
                title_keywords_a[5] = "";
                title_keywords_a[6] = "";
                title_keywords_a[7] = "";
                title_keywords_a[8] = "";
                title_keywords_a[9] = "";
                title_keywords_a[10] = "";
                title_keywords_a[11] = "";
                title_keywords_a[12] = "";
                title_keywords_a[13] = "";
                title_keywords_a[14] = "";
                title_keywords_a[15] = "";
                title_keywords_a[16] = "";
                title_keywords_a[17] = "";
                title_keywords_a[18] = "";
                title_keywords_a[19] = "";
                title_keywords_a[20] = "";


                int i = 0;
                boolean jump_directory_bool = false;
                while (key_pos < title_char_count) {
                    if (ch_array_title[key_pos] != ' ') {
                        title_keywords_a[i] += ch_array_title[key_pos];
                    } else {
                        title_keywords_a[i] += ch_array_title[key_pos];
                        i = i + 1;
                        if ((i - 1) == title_word_count - 1) {
                            jump_directory_bool = true;
                        }

                    }
                    key_pos += 1;
                    if (jump_directory_bool == true) {
                        break;
                    }
                }
                for (int j = 0; j < title_word_count; ++j) {
                    title_report = title_report + "\n\t\t- " + title_keywords_a[j];
                }

                strovvhead_title=title_string;
                strovvbody_title=title_report;

            }

//HEADERS Section
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                h1_size = document.getElementsByTag("h1").size();
                h2_size = document.getElementsByTag("h2").size();
                h3_size = document.getElementsByTag("h3").size();
                h4_size = document.getElementsByTag("h4").size();
                h5_size = document.getElementsByTag("h5").size();
                h6_size = document.getElementsByTag("h6").size();

                if (h1_size == 0) {
                    h1_bool = false;//not available
                    bool_hdrs1=false;
                } else {
                    h1_bool = true;
                    bool_hdrs1=true;
                }
                if (h2_size == 0) {
                    h2_bool = false;//not available
                    bool_hdrs2=false;
                } else {
                    h2_bool = true;
                    bool_hdrs2=true;
                }
                if (h3_size == 0) {
                    bool_hdrs3=false;
                    h3_bool = false;//not available
                } else {
                    bool_hdrs3=true;
                    h3_bool = true;
                }
                if (h4_size == 0) {
                    bool_hdrs4=false;
                    h4_bool = false;//not available
                } else {
                    bool_hdrs4=true;
                    h4_bool = true;
                }
                if (h5_size == 0) {
                    bool_hdrs5=false;
                    h5_bool = false;//not available
                } else {
                    bool_hdrs5=true;
                    h5_bool = true;
                }
                if (h6_size == 0) {
                    bool_hdrs6=false;
                    h6_bool = false;//not available
                } else {
                    bool_hdrs6=true;
                    h6_bool = true;
                }
                h1_string = "";
                h2_string = "";
                h3_string = "";
                h4_string = "";
                h5_string = "";
                h6_string = "";

                h1_string_ftc = "";
                h2_string_ftc = "";
                h3_string_ftc = "";
                h4_string_ftc = "";
                h5_string_ftc = "";
                h6_string_ftc = "";

                h1_tws = 0;
                h2_tws = 0;
                h3_tws = 0;
                h4_tws = 0;
                h5_tws = 0;
                h6_tws = 0;

                Elements hTags = document.select("h1, h2, h3, h4, h5, h6");


                //group of all h1 tags
                if (h1_bool == true) {


                    Elements h1Tags = hTags.select("h1");
                    int i = 0;
                    for (Element h1Tag : h1Tags) {
                        i = i + 1;
                        h1_string = h1_string + "\n\t" + i + ". " + h1Tag.text();
                        h1_string_ftc = h1_string_ftc + h1Tag.text();
                    }
                    //fetch the h1_char_count, h1_word_count, h1_ws_count
                    char[] ch_array_h1 = h1_string_ftc.toCharArray();
                    h1_char_count = h1_string_ftc.length();

                    //white space count for h1
                    for (int o = 0; o < h1_char_count; ++o) {
                        if (ch_array_h1[o] == ' ') {
                            h1_tws += 1;
                        }
                    }
                    //words count for h1
                    if (ch_array_h1[0] == ' ') {

                        if (ch_array_h1[h1_char_count - 1] == ' ') {
                            if (h1_tws == 2) {

                                h1_twords = 1;
                            }
                            if (h1_tws > 2) {
                                h1_twords = h1_tws - 1;
                            }
                        } else {
                            if (h1_tws == 1) {
                                h1_twords = 1;
                            }
                            if (h1_tws > 1) {
                                h1_twords = h1_tws;
                            }
                        }
                    }
                    else {
                        if (ch_array_h1[h1_char_count - 1] == ' ') {
                            if (h1_tws == 1) {
                                h1_twords = 1;
                            }
                            if (h1_tws > 1) {
                                h1_twords = h1_tws;
                            }
                        } else {
                            if (h1_tws == 0) {
                                h1_twords = 1;
                            }
                            if (h1_tws > 0) {
                                h1_twords = h1_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h1[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h1_char_count) {
                        if (ch_array_h1[key_pos] != ' ') {
                            h1_total_a[i] += ch_array_h1[key_pos];
                        } else {
                            h1_total_a[i] += ch_array_h1[key_pos];
                            i = i + 1;
                            if ((i - 1) == h1_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h1 report
                    h1_report = "";
                    h1_report += "h1 Summary:\n\n" + "There are " + h1_size + " h1 headers. Each of them are provided below.";
                    h1_report = h1_report + h1_string + "\n\n1. LENGTH: \n\t\t- " + h1_char_count + " characters\n\t\t- or, " + h1_twords + " keywords & " + h1_tws + " whitespace(s).";
                    h1_report = h1_report + "\n\n2. h1 KEYWORDS:";
                    for (i = 0; i < h1_twords; ++i) {
                        h1_report = h1_report + "\n\t\t- " + h1_total_a[i];
                    }

                    strovvhead_H1=h1_size+" H1 headers Exist !";
                    strovvbody_H1=h1_report;
                }
                //group of all h2 tags
                if (h2_bool == true) {



                    Elements h2Tags = hTags.select("h2");
                    int i = 0;
                    for (Element h2Tag : h2Tags) {
                        i = i + 1;
                        h2_string = h2_string + "\n\t" + i + ". " + h2Tag.text();
                        h2_string_ftc = h2_string_ftc + h2Tag.text();
                    }
                    //fetch the h2_char_count, h2_word_count, h2_ws_count
                    char[] ch_array_h2 = h2_string_ftc.toCharArray();
                    h2_char_count = h2_string_ftc.length();

                    //white space count for h2
                    for (int o = 0; o < h2_char_count; ++o) {
                        if (ch_array_h2[o] == ' ') {
                            h2_tws += 1;
                        }
                    }
                    //words count for h2
                    if (ch_array_h2[0] == ' ') {

                        if (ch_array_h2[h2_char_count - 1] == ' ') {
                            if (h2_tws == 2) {

                                h2_twords = 1;
                            }
                            if (h2_tws > 2) {
                                h2_twords = h2_tws - 1;
                            }
                        } else {
                            if (h2_tws == 1) {
                                h2_twords = 1;
                            }
                            if (h2_tws > 1) {
                                h2_twords = h2_tws;
                            }
                        }
                    } else {
                        if (ch_array_h2[h2_char_count - 1] == ' ') {
                            if (h2_tws == 1) {
                                h2_twords = 1;
                            }
                            if (h2_tws > 1) {
                                h2_twords = h2_tws;
                            }
                        } else {
                            if (h2_tws == 0) {
                                h2_twords = 1;
                            }
                            if (h2_tws > 0) {
                                h2_twords = h2_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h2[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h2_char_count) {
                        if (ch_array_h2[key_pos] != ' ') {
                            h2_total_a[i] += ch_array_h2[key_pos];
                        } else {
                            h2_total_a[i] += ch_array_h2[key_pos];
                            i = i + 1;
                            if ((i - 1) == h2_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h2 report
                    h2_report = "";
                    h2_report += "h2 Summary:\n\n" + "There are " + h2_size + " h2 headers. Each of them are provided below.";
                    h2_report = h2_report + h2_string + "\n\n1. LENGTH: \n\t\t- " + h2_char_count + " characters\n\t\t- or, " + h2_twords + " keywords & " + h2_tws + " whitespace(s).";
                    h2_report = h2_report + "\n\n2. h2 KEYWORDS:";
                    for (i = 0; i < h2_twords; ++i) {
                        h2_report = h2_report + "\n\t\t- " + h2_total_a[i];
                    }

                    strovvhead_H2=h2_size+" H2 headers Exist !";
                    strovvbody_H2=h2_report;
                }
                //group of all h3 tags
                if (h3_bool == true) {



                    Elements h3Tags = hTags.select("h3");
                    int i = 0;
                    for (Element h3Tag : h3Tags) {
                        i = i + 1;
                        h3_string = h3_string + "\n\t" + i + ". " + h3Tag.text();
                        h3_string_ftc = h3_string_ftc + h3Tag.text();
                    }
                    //fetch the h3_char_count, h3_word_count, h3_ws_count
                    char[] ch_array_h3 = h3_string_ftc.toCharArray();
                    h3_char_count = h3_string_ftc.length();

                    //white space count for h3
                    for (int o = 0; o < h3_char_count; ++o) {
                        if (ch_array_h3[o] == ' ') {
                            h3_tws += 1;
                        }
                    }
                    //words count for h3
                    if (ch_array_h3[0] == ' ') {

                        if (ch_array_h3[h3_char_count - 1] == ' ') {
                            if (h3_tws == 2) {

                                h3_twords = 1;
                            }
                            if (h3_tws > 2) {
                                h3_twords = h3_tws - 1;
                            }
                        } else {
                            if (h3_tws == 1) {
                                h3_twords = 1;
                            }
                            if (h3_tws > 1) {
                                h3_twords = h3_tws;
                            }
                        }
                    } else {
                        if (ch_array_h3[h3_char_count - 1] == ' ') {
                            if (h3_tws == 1) {
                                h3_twords = 1;
                            }
                            if (h3_tws > 1) {
                                h3_twords = h3_tws;
                            }
                        } else {
                            if (h3_tws == 0) {
                                h3_twords = 1;
                            }
                            if (h3_tws > 0) {
                                h3_twords = h3_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h3[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h3_char_count) {
                        if (ch_array_h3[key_pos] != ' ') {
                            h3_total_a[i] += ch_array_h3[key_pos];
                        } else {
                            h3_total_a[i] += ch_array_h3[key_pos];
                            i = i + 1;
                            if ((i - 1) == h3_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h3 report
                    h3_report = "";
                    h3_report += "h3 Summary:\n\n" + "There are " + h3_size + " h3 headers. Each of them are provided below.";
                    h3_report = h3_report + h3_string + "\n\n1. LENGTH: \n\t\t- " + h3_char_count + " characters\n\t\t- or, " + h3_twords + " keywords & " + h3_tws + " whitespace(s).";
                    h3_report = h3_report + "\n\n2. h3 KEYWORDS:";
                    for (i = 0; i < h3_twords; ++i) {
                        h3_report = h3_report + "\n\t\t- " + h3_total_a[i];
                    }
                    strovvhead_H3=h3_size+" H3 headers Exist !";
                    strovvbody_H3=h3_report;
                }
                //group of all h4 tags
                if (h4_bool == true) {

                    Elements h4Tags = hTags.select("h4");
                    int i = 0;
                    for (Element h4Tag : h4Tags) {
                        i = i + 1;
                        h4_string = h4_string + "\n\t" + i + ". " + h4Tag.text();
                        h4_string_ftc = h4_string_ftc + h4Tag.text();
                    }
                    //fetch the h4_char_count, h4_word_count, h4_ws_count
                    char[] ch_array_h4 = h4_string_ftc.toCharArray();
                    h4_char_count = h4_string_ftc.length();

                    //white space count for h4
                    for (int o = 0; o < h4_char_count; ++o) {
                        if (ch_array_h4[o] == ' ') {
                            h4_tws += 1;
                        }
                    }
                    //words count for h4
                    if (ch_array_h4[0] == ' ') {

                        if (ch_array_h4[h4_char_count - 1] == ' ') {
                            if (h4_tws == 2) {

                                h4_twords = 1;
                            }
                            if (h4_tws > 2) {
                                h4_twords = h4_tws - 1;
                            }
                        } else {
                            if (h4_tws == 1) {
                                h4_twords = 1;
                            }
                            if (h4_tws > 1) {
                                h4_twords = h4_tws;
                            }
                        }
                    } else {
                        if (ch_array_h4[h4_char_count - 1] == ' ') {
                            if (h4_tws == 1) {
                                h4_twords = 1;
                            }
                            if (h4_tws > 1) {
                                h4_twords = h4_tws;
                            }
                        } else {
                            if (h4_tws == 0) {
                                h4_twords = 1;
                            }
                            if (h4_tws > 0) {
                                h4_twords = h4_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h4[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h4_char_count) {
                        if (ch_array_h4[key_pos] != ' ') {
                            h4_total_a[i] += ch_array_h4[key_pos];
                        } else {
                            h4_total_a[i] += ch_array_h4[key_pos];
                            i = i + 1;
                            if ((i - 1) == h4_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h4 report
                    h4_report = "";
                    h4_report += "h4 Summary:\n\n" + "There are " + h4_size + " h4 headers. Each of them are provided below.";
                    h4_report = h4_report + h4_string + "\n\n1. LENGTH: \n\t\t- " + h4_char_count + " characters\n\t\t- or, " + h4_twords + " keywords & " + h4_tws + " whitespace(s).";
                    h4_report = h4_report + "\n\n2. h4 KEYWORDS:";
                    for (i = 0; i < h4_twords; ++i) {
                        h4_report = h4_report + "\n\t\t- " + h4_total_a[i];
                    }

                    strovvhead_H4=h4_size+" H4 headers Exist !";
                    strovvbody_H4=h4_report;
                }
                //group of all h5 tags
                if (h5_bool == true) {



                    Elements h5Tags = hTags.select("h5");
                    int i = 0;
                    for (Element h5Tag : h5Tags) {
                        i = i + 1;
                        h5_string = h5_string + "\n\t" + i + ". " + h5Tag.text();
                        h5_string_ftc = h5_string_ftc + h5Tag.text();
                    }
                    //fetch the h5_char_count, h5_word_count, h5_ws_count
                    char[] ch_array_h5 = h5_string_ftc.toCharArray();
                    h5_char_count = h5_string_ftc.length();

                    //white space count for h5
                    for (int o = 0; o < h5_char_count; ++o) {
                        if (ch_array_h5[o] == ' ') {
                            h5_tws += 1;
                        }
                    }
                    //words count for h5
                    if (ch_array_h5[0] == ' ') {

                        if (ch_array_h5[h5_char_count - 1] == ' ') {
                            if (h5_tws == 2) {

                                h5_twords = 1;
                            }
                            if (h5_tws > 2) {
                                h5_twords = h5_tws - 1;
                            }
                        } else {
                            if (h5_tws == 1) {
                                h5_twords = 1;
                            }
                            if (h5_tws > 1) {
                                h5_twords = h5_tws;
                            }
                        }
                    } else {
                        if (ch_array_h5[h5_char_count - 1] == ' ') {
                            if (h5_tws == 1) {
                                h5_twords = 1;
                            }
                            if (h5_tws > 1) {
                                h5_twords = h5_tws;
                            }
                        } else {
                            if (h5_tws == 0) {
                                h5_twords = 1;
                            }
                            if (h5_tws > 0) {
                                h5_twords = h5_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h5[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h5_char_count) {
                        if (ch_array_h5[key_pos] != ' ') {
                            h5_total_a[i] += ch_array_h5[key_pos];
                        } else {
                            h5_total_a[i] += ch_array_h5[key_pos];
                            i = i + 1;
                            if ((i - 1) == h5_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h5 report
                    h5_report = "";
                    h5_report += "h5 Summary:\n\n" + "There are " + h5_size + " h5 headers. Each of them are provided below.";
                    h5_report = h5_report + h5_string + "\n\n1. LENGTH: \n\t\t- " + h5_char_count + " characters\n\t\t- or, " + h5_twords + " keywords & " + h5_tws + " whitespace(s).";
                    h5_report = h5_report + "\n\n2. h5 KEYWORDS:";
                    for (i = 0; i < h5_twords; ++i) {
                        h5_report = h5_report + "\n\t\t- " + h5_total_a[i];
                    }
                    strovvhead_H5=h5_size+" H5 headers Exist !";
                    strovvbody_H5=h5_report;
                }
                //group of all h6 tags
                if (h6_bool == true) {

                    Elements h6Tags = hTags.select("h6");
                    int i = 0;
                    for (Element h6Tag : h6Tags) {
                        i = i + 1;
                        h6_string = h6_string + "\n\t" + i + ". " + h6Tag.text();
                        h6_string_ftc = h6_string_ftc + h6Tag.text();
                    }
                    //fetch the h6_char_count, h6_word_count, h6_ws_count
                    char[] ch_array_h6 = h6_string_ftc.toCharArray();
                    h6_char_count = h6_string_ftc.length();

                    //white space count for h6
                    for (int o = 0; o < h6_char_count; ++o) {
                        if (ch_array_h6[o] == ' ') {
                            h6_tws += 1;
                        }
                    }
                    //words count for h6
                    if (ch_array_h6[0] == ' ') {

                        if (ch_array_h6[h6_char_count - 1] == ' ') {
                            if (h6_tws == 2) {

                                h6_twords = 1;
                            }
                            if (h6_tws > 2) {
                                h6_twords = h6_tws - 1;
                            }
                        } else {
                            if (h6_tws == 1) {
                                h6_twords = 1;
                            }
                            if (h6_tws > 1) {
                                h6_twords = h6_tws;
                            }
                        }
                    } else {
                        if (ch_array_h6[h6_char_count - 1] == ' ') {
                            if (h6_tws == 1) {
                                h6_twords = 1;
                            }
                            if (h6_tws > 1) {
                                h6_twords = h6_tws;
                            }
                        } else {
                            if (h6_tws == 0) {
                                h6_twords = 1;
                            }
                            if (h6_tws > 0) {
                                h6_twords = h6_tws + 1;
                            }
                        }
                    }
                    //keywords
                    int hello;
                    for (i = 0; i < title_char_count; ++i) {
                        if (ch_array_h6[i] != ' ') {
                            key_pos = i;
                            hello = i;
                            break;
                        }
                    }
                    i = 0;
                    boolean jump_directory_bool = false;
                    while (key_pos < h6_char_count) {
                        if (ch_array_h6[key_pos] != ' ') {
                            h6_total_a[i] += ch_array_h6[key_pos];
                        } else {
                            h6_total_a[i] += ch_array_h6[key_pos];
                            i = i + 1;
                            if ((i - 1) == h6_twords - 1) {
                                jump_directory_bool = true;
                            }

                        }
                        key_pos += 1;
                        if (jump_directory_bool == true) {
                            break;
                        }
                    }

                    //h6 report
                    h6_report = "";
                    h6_report += "h6 Summary:\n\n" + "There are " + h6_size + " h6 headers. Each of them are provided below.";
                    h6_report = h6_report + h6_string + "\n\n1. LENGTH: \n\t\t- " + h6_char_count + " characters\n\t\t- or, " + h6_twords + " keywords & " + h6_tws + " whitespace(s).";
                    h6_report = h6_report + "\n\n2. h6 KEYWORDS:\n";
                    for (i = 0; i < h6_twords; ++i) {
                        h6_report = h6_report + "\n\t\t- " + h6_total_a[i];
                    }
                    strovvhead_H6=h6_size+" H6 headers Exist !";
                    strovvbody_H6=h6_report;
                }

                headers_report_h1_h6 = "";
                //headers report


                headers_report_h1_h6 = "Available Headers from h1 to h6:";
                if (h1_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h1 tag is available";
                }
                if (h2_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h2 tag is available";
                }
                if (h3_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h3 tag is available";
                }
                if (h4_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h4 tag is available";
                }
                if (h5_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h5 tag is available";
                }
                if (h6_bool == true) {
                    headers_report_h1_h6 = headers_report_h1_h6 + "\n\t\t- h6 tag is available";
                }
                int total_h1_h6_words = h1_twords + h2_twords + h3_twords + h4_twords + h5_twords + h6_twords;
                headers_report_h1_h6 = headers_report_h1_h6 + "\n\nTotal Keywords Contributed \nfrom Headers <h1> to <h6> is: " + total_h1_h6_words + " keywords";

                if (h1_bool == true) {
                    headers_report_h1_h6 += "\n\n\n---------------------------------------------------------------------------------------------\n" + h1_report;
                }
                if (h2_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h2_report;
                }
                if (h3_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h3_report;
                }
                if (h4_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h4_report;
                }
                if (h5_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h5_report;
                }
                if (h6_bool == true) {
                    headers_report_h1_h6 += "\n---------------------------------------------------------------------------------------------\n\n" + h6_report;
                }

            }

//BODY Tag
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                p_tags_size = document.getElementsByTag("p").size();
                div_tags_size = document.getElementsByTag("div").size();
                h1_tags_size = document.getElementsByTag("h1").size();
                h2_tags_size = document.getElementsByTag("h2").size();
                h3_tags_size = document.getElementsByTag("h3").size();
                h4_tags_size = document.getElementsByTag("h4").size();
                h5_tags_size = document.getElementsByTag("h5").size();
                h6_tags_size = document.getElementsByTag("h6").size();
                img_tags_size = document.getElementsByTag("img").size();
                href_tags_size = document.select("a[href]").size();
                meta_description_tags_size = document.select("meta[name=description]").size();
                meta_keywords_size = document.select("meta[name=keywords]").size();
                meta_robots_size = document.select("meta[name=robot]").size();
                meta_view_port_size = document.select("meta[name=viewport]").size();
                link_rel_canonical_tag_size = document.select("link[rel=canonical]").size();
                meta_author_size = document.select("meta[name=author]").size();


//                meta_keywords_string = String.valueOf(document.attr("name:keywords"));
//                meta_description_string = document.attr("name:description");
//                meta_viewport_string = document.attr("name:viewport");
//                meta_robots_string = document.attr("name:robots");
//                rel_canonical_report_string=document.attr("name:canonical");
//                meta_author_string=document.attr("name:author");

                meta__tags_total = document.select("meta").size();

                p_tags_bool = false;
                div_tags_bool = false;
                h1_tags_bool = false;
                h2_tags_bool = false;
                h3_tags_bool = false;
                h4_tags_bool = false;
                h5_tags_bool = false;
                h6_tags_bool = false;
                img_tags_bool = false;
                href_tags_bool = false;
                meta_description_tags_bool = false;
                meta_keywords_bool = false;
                meta_robots_bool = false;
                meta_view_port_bool = false;
                link_rel_canonical_tag_bool = false;
                meta_author_bool = false;


                if (p_tags_size > 0)
                    p_tags_bool = true;
                if (div_tags_size > 0)
                    div_tags_bool = true;
                if (h1_tags_size > 0)
                    h1_tags_bool = true;
                if (h2_tags_size > 0)
                    h2_tags_bool = true;
                if (h3_tags_size > 0)
                    h3_tags_bool = true;
                if (h4_tags_size > 0)
                    h4_tags_bool = true;
                if (h5_tags_size > 0)
                    h5_tags_bool = true;
                if (h6_tags_size > 0)
                    h6_tags_bool = true;
                if (img_tags_size > 0)
                    img_tags_bool = true;
                if (href_tags_size > 0)
                    href_tags_bool = true;
                if (meta_description_tags_size > 0)
                    meta_description_tags_bool = true;
                if (meta_keywords_size > 0)
                    meta_keywords_bool = true;
                if (meta_robots_size > 0)
                    meta_robots_bool = true;
                if (meta_view_port_size > 0)
                    meta_view_port_bool = true;
                if (link_rel_canonical_tag_size > 0)
                    link_rel_canonical_tag_bool = true;
                if (meta_author_size > 0)
                    meta_author_bool = true;


                body_report = "";
                body_report = "The Site's Body Element Has ..\n";

                if (p_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + p_tags_size + " <p> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + p_tags_size + " <p> tag(s).";

                if (div_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + div_tags_size + " <div> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + div_tags_size + " <div> tag(s).";

                if (h1_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h1_tags_size + " <h1> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h1_tags_size + " <h1> tag(s).";


                if (h2_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h2_tags_size + " <h2> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h2_tags_size + " <h2> tag(s).";

                if (h3_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h3_tags_size + " <h3> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h3_tags_size + " <h3> tag(s).";

                if (h4_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h4_tags_size + " <h4> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h4_tags_size + " <h4> tag(s).";

                if (h5_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h5_tags_size + " <h5> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h5_tags_size + " <h5> tag(s).";

                if (h6_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + h6_tags_size + " <h6> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + h6_tags_size + " <h6> tag(s).";

                if (img_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + img_tags_size + " <img> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + img_tags_size + " <img> tag(s).";

                if (href_tags_size > 0)
                    body_report = body_report + "\n\t\t- " + href_tags_size + " <a href> tag(s).";
                else
                    body_report = body_report + "\n\t\t- " + href_tags_size + " <a href> tag(s).";

                if (meta__tags_total > 0) {
                    body_report = body_report + "\n\n\n\t- TOTAL META Tags Available: " + meta__tags_total + " <meta> tag(s).";
                } else {
                    body_report = body_report + "\n\n\n\t- TOTAL META Tags Available: " + meta__tags_total + " <meta> tag.";
                }

                if (meta_description_tags_size > 0)
                    body_report = body_report + "\n\n\n\t\t- " + meta_description_tags_size + " meta description tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_description_tags_size + " meta description tag.";

                if (meta_keywords_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_keywords_size + " meta keyword tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_keywords_size + " meta keyword tag.";

                if (meta_robots_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_robots_size + " meta robots tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_robots_size + " meta robots tag.";

                if (meta_view_port_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_view_port_size + " meta View port tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_view_port_size + " meta View port tag.";

                if (meta_author_size > 0)
                    body_report = body_report + "\n\t\t- " + meta_author_size + " meta Author tag.";
                else
                    body_report = body_report + "\n\t\t- " + meta_author_size + " meta Author tag.";


                if (link_rel_canonical_tag_size > 0)
                    body_report = body_report + "\n\t\t- " + link_rel_canonical_tag_size + " Link rel canonical tag.";
                else
                    body_report = body_report + "\n\t\t- " + link_rel_canonical_tag_size + " Link rel canonical tag.";
            }

//LINKS Tag
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);

                Elements links = document.select("a[href]");
                int i = 0;
                highlightedLink_str_a[0] = "";
                highlightedLink_str_a[1] = "";
                highlightedLink_str_a[2] = "";
                highlightedLink_str_a[3] = "";
                highlightedLink_str_a[4] = "";
                highlightedLink_str_a[5] = "";
                highlightedLink_str_a[6] = "";
                highlightedLink_str_a[7] = "";
                highlightedLink_str_a[8] = "";
                highlightedLink_str_a[9] = "";
                highlightedLink_str_a[10] = "";
                highlightedLink_str_a[11] = "";
                highlightedLink_str_a[12] = "";
                highlightedLink_str_a[13] = "";
                highlightedLink_str_a[14] = "";
                highlightedLink_str_a[15] = "";
                highlightedLink_str_a[16] = "";
                highlightedLink_str_a[17] = "";
                highlightedLink_str_a[18] = "";
                highlightedLink_str_a[19] = "";
                highlightedLink_str_a[20] = "";
                highlightedLink_str_a[21] = "";
                highlightedLink_str_a[22] = "";
                highlightedLink_str_a[23] = "";
                highlightedLink_str_a[24] = "";
                highlightedLink_str_a[25] = "";
                highlightedLink_str_a[26] = "";
                highlightedLink_str_a[27] = "";
                highlightedLink_str_a[28] = "";
                highlightedLink_str_a[29] = "";
                highlightedLink_str_a[30] = "";
                highlightedLink_str_a[31] = "";
                highlightedLink_str_a[32] = "";
                highlightedLink_str_a[33] = "";
                highlightedLink_str_a[34] = "";
                highlightedLink_str_a[35] = "";
                highlightedLink_str_a[36] = "";
                highlightedLink_str_a[37] = "";
                highlightedLink_str_a[38] = "";
                highlightedLink_str_a[39] = "";
                highlightedLink_str_a[40] = "";
                highlightedLink_str_a[41] = "";
                highlightedLink_str_a[42] = "";
                highlightedLink_str_a[43] = "";
                highlightedLink_str_a[44] = "";
                highlightedLink_str_a[45] = "";
                highlightedLink_str_a[46] = "";
                highlightedLink_str_a[47] = "";
                highlightedLink_str_a[48] = "";
                highlightedLink_str_a[49] = "";
                highlightedLink_str_a[50] = "";
                highlightedLink_str_a[51] = "";
                highlightedLink_str_a[52] = "";
                highlightedLink_str_a[53] = "";
                highlightedLink_str_a[54] = "";
                highlightedLink_str_a[55] = "";
                highlightedLink_str_a[56] = "";
                highlightedLink_str_a[57] = "";
                highlightedLink_str_a[58] = "";
                highlightedLink_str_a[59] = "";
                highlightedLink_str_a[60] = "";

                highlightedLink_str_a[61] = "";
                highlighted_text_str_a[61] = "";
                highlightedLink_str_a[62] = "";
                highlighted_text_str_a[62] = "";
                highlightedLink_str_a[63] = "";
                highlighted_text_str_a[63] = "";
                highlightedLink_str_a[64] = "";
                highlighted_text_str_a[64] = "";
                highlightedLink_str_a[65] = "";
                highlighted_text_str_a[65] = "";
                highlightedLink_str_a[66] = "";
                highlighted_text_str_a[66] = "";
                highlightedLink_str_a[67] = "";
                highlighted_text_str_a[67] = "";
                highlightedLink_str_a[68] = "";
                highlighted_text_str_a[68] = "";
                highlightedLink_str_a[69] = "";
                highlighted_text_str_a[69] = "";
                highlightedLink_str_a[70] = "";
                highlighted_text_str_a[70] = "";
                highlightedLink_str_a[71] = "";
                highlighted_text_str_a[71] = "";
                highlightedLink_str_a[72] = "";
                highlighted_text_str_a[72] = "";
                highlightedLink_str_a[73] = "";
                highlighted_text_str_a[73] = "";
                highlightedLink_str_a[74] = "";
                highlighted_text_str_a[74] = "";
                highlightedLink_str_a[75] = "";
                highlighted_text_str_a[75] = "";
                highlightedLink_str_a[76] = "";
                highlighted_text_str_a[76] = "";
                highlightedLink_str_a[77] = "";
                highlighted_text_str_a[77] = "";
                highlightedLink_str_a[78] = "";
                highlighted_text_str_a[78] = "";
                highlightedLink_str_a[79] = "";
                highlighted_text_str_a[79] = "";
                highlightedLink_str_a[80] = "";
                highlighted_text_str_a[80] = "";
                highlightedLink_str_a[81] = "";
                highlighted_text_str_a[81] = "";
                highlightedLink_str_a[82] = "";
                highlighted_text_str_a[82] = "";
                highlightedLink_str_a[83] = "";
                highlighted_text_str_a[83] = "";
                highlightedLink_str_a[84] = "";
                highlighted_text_str_a[84] = "";
                highlightedLink_str_a[85] = "";
                highlighted_text_str_a[85] = "";
                highlightedLink_str_a[86] = "";
                highlighted_text_str_a[86] = "";
                highlightedLink_str_a[87] = "";
                highlighted_text_str_a[87] = "";
                highlightedLink_str_a[88] = "";
                highlighted_text_str_a[88] = "";
                highlightedLink_str_a[89] = "";
                highlighted_text_str_a[89] = "";
                highlightedLink_str_a[90] = "";
                highlighted_text_str_a[90] = "";
                highlightedLink_str_a[91] = "";
                highlighted_text_str_a[91] = "";
                highlightedLink_str_a[92] = "";
                highlighted_text_str_a[92] = "";
                highlightedLink_str_a[93] = "";
                highlighted_text_str_a[93] = "";
                highlightedLink_str_a[94] = "";
                highlighted_text_str_a[94] = "";
                highlightedLink_str_a[95] = "";
                highlighted_text_str_a[95] = "";
                highlightedLink_str_a[96] = "";
                highlighted_text_str_a[96] = "";
                highlightedLink_str_a[97] = "";
                highlighted_text_str_a[97] = "";
                highlightedLink_str_a[98] = "";
                highlighted_text_str_a[98] = "";
                highlightedLink_str_a[99] = "";
                highlighted_text_str_a[99] = "";
                highlightedLink_str_a[100] = "";
                highlighted_text_str_a[100] = "";
                highlightedLink_str_a[101] = "";
                highlighted_text_str_a[101] = "";
                highlightedLink_str_a[102] = "";
                highlighted_text_str_a[102] = "";
                highlightedLink_str_a[103] = "";
                highlighted_text_str_a[103] = "";
                highlightedLink_str_a[104] = "";
                highlighted_text_str_a[104] = "";
                highlightedLink_str_a[105] = "";
                highlighted_text_str_a[105] = "";
                highlightedLink_str_a[106] = "";
                highlighted_text_str_a[106] = "";
                highlightedLink_str_a[107] = "";
                highlighted_text_str_a[107] = "";
                highlightedLink_str_a[108] = "";
                highlighted_text_str_a[108] = "";
                highlightedLink_str_a[109] = "";
                highlighted_text_str_a[109] = "";
                highlightedLink_str_a[110] = "";
                highlighted_text_str_a[110] = "";
                highlightedLink_str_a[111] = "";
                highlighted_text_str_a[111] = "";
                highlightedLink_str_a[112] = "";
                highlighted_text_str_a[112] = "";
                highlightedLink_str_a[113] = "";
                highlighted_text_str_a[113] = "";
                highlightedLink_str_a[114] = "";
                highlighted_text_str_a[114] = "";
                highlightedLink_str_a[115] = "";
                highlighted_text_str_a[115] = "";
                highlightedLink_str_a[116] = "";
                highlighted_text_str_a[116] = "";
                highlightedLink_str_a[117] = "";
                highlighted_text_str_a[117] = "";
                highlightedLink_str_a[118] = "";
                highlighted_text_str_a[118] = "";
                highlightedLink_str_a[119] = "";
                highlighted_text_str_a[119] = "";
                highlightedLink_str_a[120] = "";
                highlighted_text_str_a[120] = "";
                highlightedLink_str_a[121] = "";
                highlighted_text_str_a[121] = "";
                highlightedLink_str_a[122] = "";
                highlighted_text_str_a[122] = "";
                highlightedLink_str_a[123] = "";
                highlighted_text_str_a[123] = "";
                highlightedLink_str_a[124] = "";
                highlighted_text_str_a[124] = "";
                highlightedLink_str_a[125] = "";
                highlighted_text_str_a[125] = "";
                highlightedLink_str_a[126] = "";
                highlighted_text_str_a[126] = "";
                highlightedLink_str_a[127] = "";
                highlighted_text_str_a[127] = "";
                highlightedLink_str_a[128] = "";
                highlighted_text_str_a[128] = "";
                highlightedLink_str_a[129] = "";
                highlighted_text_str_a[129] = "";
                highlightedLink_str_a[130] = "";
                highlighted_text_str_a[130] = "";
                highlightedLink_str_a[131] = "";
                highlighted_text_str_a[131] = "";
                highlightedLink_str_a[132] = "";
                highlighted_text_str_a[132] = "";
                highlightedLink_str_a[133] = "";
                highlighted_text_str_a[133] = "";
                highlightedLink_str_a[134] = "";
                highlighted_text_str_a[134] = "";
                highlightedLink_str_a[135] = "";
                highlighted_text_str_a[135] = "";
                highlightedLink_str_a[136] = "";
                highlighted_text_str_a[136] = "";
                highlightedLink_str_a[137] = "";
                highlighted_text_str_a[137] = "";
                highlightedLink_str_a[138] = "";
                highlighted_text_str_a[138] = "";
                highlightedLink_str_a[139] = "";
                highlighted_text_str_a[139] = "";
                highlightedLink_str_a[140] = "";
                highlighted_text_str_a[140] = "";
                highlightedLink_str_a[141] = "";
                highlighted_text_str_a[141] = "";
                highlightedLink_str_a[142] = "";
                highlighted_text_str_a[142] = "";
                highlightedLink_str_a[143] = "";
                highlighted_text_str_a[143] = "";
                highlightedLink_str_a[144] = "";
                highlighted_text_str_a[144] = "";
                highlightedLink_str_a[145] = "";
                highlighted_text_str_a[145] = "";
                highlightedLink_str_a[146] = "";
                highlighted_text_str_a[146] = "";
                highlightedLink_str_a[147] = "";
                highlighted_text_str_a[147] = "";
                highlightedLink_str_a[148] = "";
                highlighted_text_str_a[148] = "";
                highlightedLink_str_a[149] = "";
                highlighted_text_str_a[149] = "";
                highlightedLink_str_a[150] = "";
                highlighted_text_str_a[150] = "";
                highlightedLink_str_a[151] = "";
                highlighted_text_str_a[151] = "";
                highlightedLink_str_a[152] = "";
                highlighted_text_str_a[152] = "";
                highlightedLink_str_a[153] = "";
                highlighted_text_str_a[153] = "";
                highlightedLink_str_a[154] = "";
                highlighted_text_str_a[154] = "";
                highlightedLink_str_a[155] = "";
                highlighted_text_str_a[155] = "";
                highlightedLink_str_a[156] = "";
                highlighted_text_str_a[156] = "";
                highlightedLink_str_a[157] = "";
                highlighted_text_str_a[157] = "";
                highlightedLink_str_a[158] = "";
                highlighted_text_str_a[158] = "";
                highlightedLink_str_a[159] = "";
                highlighted_text_str_a[159] = "";
                highlightedLink_str_a[160] = "";
                highlighted_text_str_a[160] = "";
                highlightedLink_str_a[161] = "";
                highlighted_text_str_a[161] = "";
                highlightedLink_str_a[162] = "";
                highlighted_text_str_a[162] = "";
                highlightedLink_str_a[163] = "";
                highlighted_text_str_a[163] = "";
                highlightedLink_str_a[164] = "";
                highlighted_text_str_a[164] = "";
                highlightedLink_str_a[165] = "";
                highlighted_text_str_a[165] = "";
                highlightedLink_str_a[166] = "";
                highlighted_text_str_a[166] = "";
                highlightedLink_str_a[167] = "";
                highlighted_text_str_a[167] = "";
                highlightedLink_str_a[168] = "";
                highlighted_text_str_a[168] = "";
                highlightedLink_str_a[169] = "";
                highlighted_text_str_a[169] = "";
                highlightedLink_str_a[170] = "";
                highlighted_text_str_a[170] = "";

                highlighted_text_str_a[0] = "";
                highlighted_text_str_a[1] = "";
                highlighted_text_str_a[2] = "";
                highlighted_text_str_a[3] = "";
                highlighted_text_str_a[4] = "";
                highlighted_text_str_a[5] = "";
                highlighted_text_str_a[6] = "";
                highlighted_text_str_a[7] = "";
                highlighted_text_str_a[8] = "";
                highlighted_text_str_a[9] = "";
                highlighted_text_str_a[10] = "";
                highlighted_text_str_a[11] = "";
                highlighted_text_str_a[12] = "";
                highlighted_text_str_a[13] = "";
                highlighted_text_str_a[14] = "";
                highlighted_text_str_a[15] = "";
                highlighted_text_str_a[16] = "";
                highlighted_text_str_a[17] = "";
                highlighted_text_str_a[18] = "";
                highlighted_text_str_a[19] = "";
                highlighted_text_str_a[20] = "";
                highlighted_text_str_a[21] = "";
                highlighted_text_str_a[22] = "";
                highlighted_text_str_a[23] = "";
                highlighted_text_str_a[24] = "";
                highlighted_text_str_a[25] = "";
                highlighted_text_str_a[26] = "";
                highlighted_text_str_a[27] = "";
                highlighted_text_str_a[28] = "";
                highlighted_text_str_a[29] = "";
                highlighted_text_str_a[30] = "";
                highlighted_text_str_a[31] = "";
                highlighted_text_str_a[32] = "";
                highlighted_text_str_a[33] = "";
                highlighted_text_str_a[34] = "";
                highlighted_text_str_a[35] = "";
                highlighted_text_str_a[36] = "";
                highlighted_text_str_a[37] = "";
                highlighted_text_str_a[38] = "";
                highlighted_text_str_a[39] = "";
                highlighted_text_str_a[40] = "";
                highlighted_text_str_a[41] = "";
                highlighted_text_str_a[42] = "";
                highlighted_text_str_a[43] = "";
                highlighted_text_str_a[44] = "";
                highlighted_text_str_a[45] = "";
                highlighted_text_str_a[46] = "";
                highlighted_text_str_a[47] = "";
                highlighted_text_str_a[48] = "";
                highlighted_text_str_a[49] = "";
                highlighted_text_str_a[50] = "";
                highlighted_text_str_a[51] = "";
                highlighted_text_str_a[52] = "";
                highlighted_text_str_a[53] = "";
                highlighted_text_str_a[54] = "";
                highlighted_text_str_a[55] = "";
                highlighted_text_str_a[56] = "";
                highlighted_text_str_a[57] = "";
                highlighted_text_str_a[58] = "";
                highlighted_text_str_a[59] = "";
                highlighted_text_str_a[60] = "";
                i=0;
                for (Element link : links) {
                    i += 1;
                    highlightedLink_str_a[i] += link.attr("abs:href");
                    highlighted_text_str_a[i] += link.text().trim();
                }

                links_count = i;
                if (links_count > 0) {
                    bool_ovv12Links=true;
                }else{
                    bool_ovv12Links=false;
                }

                //href_strings_report = "-------------------------------------------------------------------------------------------\n";
                //href_strings_report = "TOTAL Internal Links(href tags) with Highlighted Texts available counts to: " + i+" / "+link_text_count_size_numbers + " in numbers.\n\nNOTE: The Following List is Provided in a \"Highlighted Text and the Link\" way. Any disappearance in one of these twos means that the website developer(s) have not provided the same in purpose. .. ";
                href_strings_report += "\n\n-------------------------------------------------------------------------------------------\n\n";
                for ( int j = 0; j < i; ++j) {
                    href_strings_report = href_strings_report + "\n\t\t- \"" + highlighted_text_str_a[j] + "\"";
                    href_strings_report = href_strings_report + "\n\t\t- " + highlightedLink_str_a[j];
                    href_strings_report = href_strings_report + "\n";
                }
                strovvhead_Links=links_count+" Hyperlinks in total Exists !";
                strovvbody_Links=href_strings_report;
            }

//IMAGES Tag
            if (url_valid_on_bool == true) {
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
                img_linksrc_value[0] = "";
                img_linksrc_value[1] = "";
                img_linksrc_value[2] = "";
                img_linksrc_value[3] = "";
                img_linksrc_value[4] = "";
                img_linksrc_value[5] = "";
                img_linksrc_value[6] = "";
                img_linksrc_value[7] = "";
                img_linksrc_value[8] = "";
                img_linksrc_value[9] = "";
                img_linksrc_value[10] = "";
                img_linksrc_value[11] = "";
                img_linksrc_value[12] = "";
                img_linksrc_value[13] = "";
                img_linksrc_value[14] = "";
                img_linksrc_value[15] = "";
                img_linksrc_value[16] = "";
                img_linksrc_value[17] = "";
                img_linksrc_value[18] = "";
                img_linksrc_value[19] = "";
                img_linksrc_value[20] = "";
                img_linksrc_value[21] = "";
                img_linksrc_value[22] = "";
                img_linksrc_value[23] = "";
                img_linksrc_value[24] = "";
                img_linksrc_value[25] = "";
                img_linksrc_value[26] = "";
                img_linksrc_value[27] = "";
                img_linksrc_value[28] = "";
                img_linksrc_value[29] = "";
                img_linksrc_value[30] = "";
                img_linksrc_value[31] = "";
                img_linksrc_value[32] = "";
                img_linksrc_value[33] = "";
                img_linksrc_value[34] = "";
                img_linksrc_value[35] = "";
                img_linksrc_value[36] = "";
                img_linksrc_value[37] = "";
                img_linksrc_value[38] = "";
                img_linksrc_value[39] = "";
                img_linksrc_value[40] = "";
                img_linksrc_value[41] = "";
                img_linksrc_value[42] = "";
                img_linksrc_value[43] = "";
                img_linksrc_value[44] = "";
                img_linksrc_value[45] = "";
                img_linksrc_value[46] = "";
                img_linksrc_value[47] = "";
                img_linksrc_value[48] = "";
                img_linksrc_value[49] = "";
                img_linksrc_value[50] = "";
                img_linksrc_value[51] = "";
                img_linksrc_value[52] = "";
                img_linksrc_value[53] = "";
                img_linksrc_value[54] = "";
                img_linksrc_value[55] = "";
                img_linksrc_value[56] = "";
                img_linksrc_value[57] = "";
                img_linksrc_value[58] = "";
                img_linksrc_value[59] = "";
                img_linksrc_value[60] = "";

                img_res_value[0] = "";
                img_res_value[1] = "";
                img_res_value[2] = "";
                img_res_value[3] = "";
                img_res_value[4] = "";
                img_res_value[5] = "";
                img_res_value[6] = "";
                img_res_value[7] = "";
                img_res_value[8] = "";
                img_res_value[9] = "";
                img_res_value[10] = "";
                img_res_value[11] = "";
                img_res_value[12] = "";
                img_res_value[13] = "";
                img_res_value[14] = "";
                img_res_value[15] = "";
                img_res_value[16] = "";
                img_res_value[17] = "";
                img_res_value[18] = "";
                img_res_value[19] = "";
                img_res_value[20] = "";
                img_res_value[21] = "";
                img_res_value[22] = "";
                img_res_value[23] = "";
                img_res_value[24] = "";
                img_res_value[25] = "";
                img_res_value[26] = "";
                img_res_value[27] = "";
                img_res_value[28] = "";
                img_res_value[29] = "";
                img_res_value[30] = "";
                img_res_value[31] = "";
                img_res_value[32] = "";
                img_res_value[33] = "";
                img_res_value[34] = "";
                img_res_value[35] = "";
                img_res_value[36] = "";
                img_res_value[37] = "";
                img_res_value[38] = "";
                img_res_value[39] = "";
                img_res_value[40] = "";
                img_res_value[41] = "";
                img_res_value[42] = "";
                img_res_value[43] = "";
                img_res_value[44] = "";
                img_res_value[45] = "";
                img_res_value[46] = "";
                img_res_value[47] = "";
                img_res_value[48] = "";
                img_res_value[49] = "";
                img_res_value[50] = "";
                img_res_value[51] = "";
                img_res_value[52] = "";
                img_res_value[53] = "";
                img_res_value[54] = "";
                img_res_value[55] = "";
                img_res_value[56] = "";
                img_res_value[57] = "";
                img_res_value[58] = "";
                img_res_value[59] = "";
                img_res_value[60] = "";

                img_alt_value[0] = "";
                img_alt_value[1] = "";
                img_alt_value[2] = "";
                img_alt_value[3] = "";
                img_alt_value[4] = "";
                img_alt_value[5] = "";
                img_alt_value[6] = "";
                img_alt_value[7] = "";
                img_alt_value[8] = "";
                img_alt_value[9] = "";
                img_alt_value[10] = "";
                img_alt_value[11] = "";
                img_alt_value[12] = "";
                img_alt_value[13] = "";
                img_alt_value[14] = "";
                img_alt_value[15] = "";
                img_alt_value[16] = "";
                img_alt_value[17] = "";
                img_alt_value[18] = "";
                img_alt_value[19] = "";
                img_alt_value[20] = "";
                img_alt_value[21] = "";
                img_alt_value[22] = "";
                img_alt_value[23] = "";
                img_alt_value[24] = "";
                img_alt_value[25] = "";
                img_alt_value[26] = "";
                img_alt_value[27] = "";
                img_alt_value[28] = "";
                img_alt_value[29] = "";
                img_alt_value[30] = "";
                img_alt_value[31] = "";
                img_alt_value[32] = "";
                img_alt_value[33] = "";
                img_alt_value[34] = "";
                img_alt_value[35] = "";
                img_alt_value[36] = "";
                img_alt_value[37] = "";
                img_alt_value[38] = "";
                img_alt_value[39] = "";
                img_alt_value[40] = "";
                img_alt_value[41] = "";
                img_alt_value[42] = "";
                img_alt_value[43] = "";
                img_alt_value[44] = "";
                img_alt_value[45] = "";
                img_alt_value[46] = "";
                img_alt_value[47] = "";
                img_alt_value[48] = "";
                img_alt_value[49] = "";
                img_alt_value[50] = "";
                img_alt_value[51] = "";
                img_alt_value[52] = "";
                img_alt_value[53] = "";
                img_alt_value[54] = "";
                img_alt_value[55] = "";
                img_alt_value[56] = "";
                img_alt_value[57] = "";
                img_alt_value[58] = "";
                img_alt_value[59] = "";
                img_alt_value[60] = "";
                img_count_size = document.getElementsByTag("img").size();
                //iterate images and print image attributes
                int i = 0;
                img_alt_count_size = 0;
                for (Element image : images) {
                    i += 1;
                    img_linksrc_value[i] = image.attr("src");
                    img_res_value[i] = image.attr("width") + " x " + image.attr("height");
                    img_alt_value[i] = image.attr("alt");
                    if (img_alt_value[i] != "") {
                        img_alt_bool[i] = true;
                        img_alt_count_size += 1;
                    } else {
                        img_alt_bool[i] = false;
                    }
                }
                //images Report
                //Any images present?
                //5 images are present
                //The image along with their Alt Values are as
                //image src
                //image resolution
                //image alt value present?
                //img alt value
                //Images Report Starts Now!
                if (img_count_size < 1) {
                    img_report_string = "No Images Are present in this Site !";
                    bool_images=false;
                } else {
                    bool_images=true;
                    img_report_string = "Images(or, <img> tag(s)) are present in this Site.\n";
                    img_report_string += "\n" + img_count_size + " images are available..\nOut of which " + (img_alt_count_size) + " of them has provided Alt values.\n";
                    img_report_string += "\n\n\nThe images along with their src, size/resolution in pixels & Alt Values are as Follows.\n\n\n\n---------------------------------------------------------------------------------------------\n ";
                    for (int k = 0; k < i; ++k) {
                        img_report_string += "\n\t\t- SRC: " + img_linksrc_value[k];
                        img_report_string += "\n\t\t- RESOLUTION: " + img_res_value[k];
                        img_report_string += "\n\t\t- ALT Available(?): " + img_alt_bool[k];
                        if (img_alt_bool[k] == true) {
                            imgALT=true;
                            img_report_string += "\n\t\t- ALT value : " + img_alt_value[k] + "\n\t\t--------------------------------------------------------------\n";
                        } else {
                            img_report_string += "\n\t\t--------------------------------------------------------------\n";
                        }
                    }
                    strovvhead_Images=img_count_size+" images are available. "+(img_count_size-img_alt_count_size)+" of them has no Alt Values";
                    strovvbody_Images=img_report_string;
                }
            }

//KEYWORDS Tag0
            if (url_valid_on_bool == true) {
//                total_keywords_a[0] = "";
//                total_keywords_a[1] = "";
//                total_keywords_a[2] = "";
//                total_keywords_a[3] = "";
//                total_keywords_a[4] = "";
//                total_keywords_a[5] = "";
//                total_keywords_a[6] = "";
//                total_keywords_a[7] = "";
//                total_keywords_a[8] = "";
//                total_keywords_a[9] = "";
//                total_keywords_a[10] = "";
//                total_keywords_a[11] = "";
//                total_keywords_a[12] = "";
//                total_keywords_a[13] = "";
//                total_keywords_a[14] = "";
//                total_keywords_a[15] = "";
//                total_keywords_a[16] = "";
//                total_keywords_a[17] = "";
//                total_keywords_a[18] = "";
//                total_keywords_a[19] = "";
//                total_keywords_a[20] = "";
//                total_keywords_a[21] = "";
//                total_keywords_a[22] = "";
//                total_keywords_a[23] = "";
//                total_keywords_a[24] = "";
//                total_keywords_a[25] = "";
//                total_keywords_a[26] = "";
//                total_keywords_a[27] = "";
//                total_keywords_a[28] = "";
//                total_keywords_a[29] = "";
//                total_keywords_a[30] = "";
//                total_keywords_a[31] = "";
//                total_keywords_a[32] = "";
//                total_keywords_a[33] = "";
//                total_keywords_a[34] = "";
//                total_keywords_a[35] = "";
//                total_keywords_a[36] = "";
//                total_keywords_a[37] = "";
//                total_keywords_a[38] = "";
//                total_keywords_a[39] = "";
//                total_keywords_a[40] = "";
//                total_keywords_a[41] = "";
//                total_keywords_a[42] = "";
//                total_keywords_a[43] = "";
//                total_keywords_a[44] = "";
//                total_keywords_a[45] = "";
//                total_keywords_a[46] = "";
//                total_keywords_a[47] = "";
//                total_keywords_a[48] = "";
//                total_keywords_a[49] = "";
//                total_keywords_a[50] = "";
//                total_keywords_a[51] = "";
//                total_keywords_a[52] = "";
//                total_keywords_a[53] = "";
//                total_keywords_a[54] = "";
//                total_keywords_a[55] = "";
//                total_keywords_a[56] = "";
//                total_keywords_a[57] = "";
//                total_keywords_a[58] = "";
//                total_keywords_a[59] = "";
//                total_keywords_a[60] = "";
//                total_keywords_a[61] = "";
//                total_keywords_a[62] = "";
//                total_keywords_a[63] = "";
//                total_keywords_a[64] = "";
//                total_keywords_a[65] = "";
//                total_keywords_a[66] = "";
//                total_keywords_a[67] = "";
//                total_keywords_a[68] = "";
//                total_keywords_a[69] = "";
//                total_keywords_a[70] = "";
//                total_keywords_a[71] = "";
//                total_keywords_a[72] = "";
//                total_keywords_a[73] = "";
//                total_keywords_a[74] = "";
//                total_keywords_a[75] = "";
//                total_keywords_a[76] = "";
//                total_keywords_a[77] = "";
//                total_keywords_a[78] = "";
//                total_keywords_a[79] = "";
//                total_keywords_a[80] = "";
//                total_keywords_a[81] = "";
//                total_keywords_a[82] = "";
//                total_keywords_a[83] = "";
//                total_keywords_a[84] = "";
//                total_keywords_a[85] = "";
//                total_keywords_a[86] = "";
//                total_keywords_a[87] = "";
//                total_keywords_a[88] = "";
//                total_keywords_a[89] = "";
//                total_keywords_a[90] = "";
//                total_keywords_a[91] = "";
//                total_keywords_a[92] = "";
//                total_keywords_a[93] = "";
//                total_keywords_a[94] = "";
//                total_keywords_a[95] = "";
//                total_keywords_a[96] = "";
//                total_keywords_a[97] = "";
//                total_keywords_a[98] = "";
//                total_keywords_a[99] = "";
//                total_keywords_a[100] = "";
//                total_keywords_a[101] = "";
//                total_keywords_a[102] = "";
//                total_keywords_a[103] = "";
//                total_keywords_a[104] = "";
//                total_keywords_a[105] = "";
//                total_keywords_a[106] = "";
//                total_keywords_a[107] = "";
//                total_keywords_a[108] = "";
//                total_keywords_a[109] = "";
//                total_keywords_a[110] = "";
//                total_keywords_a[111] = "";
//                total_keywords_a[112] = "";
//                total_keywords_a[113] = "";
//                total_keywords_a[114] = "";
//                total_keywords_a[115] = "";
//                total_keywords_a[116] = "";
//                total_keywords_a[117] = "";
//                total_keywords_a[118] = "";
//                total_keywords_a[119] = "";
//                total_keywords_a[120] = "";
//                total_keywords_a[121] = "";
//                total_keywords_a[122] = "";
//                total_keywords_a[123] = "";
//                total_keywords_a[124] = "";
//                total_keywords_a[125] = "";
//                total_keywords_a[126] = "";
//                total_keywords_a[127] = "";
//                total_keywords_a[128] = "";
//                total_keywords_a[129] = "";
//                total_keywords_a[130] = "";
//                total_keywords_a[131] = "";
//                total_keywords_a[132] = "";
//                total_keywords_a[133] = "";
//                total_keywords_a[134] = "";
//                total_keywords_a[135] = "";
//                total_keywords_a[136] = "";
//                total_keywords_a[137] = "";
//                total_keywords_a[138] = "";
//                total_keywords_a[139] = "";
//                total_keywords_a[140] = "";
//                total_keywords_a[141] = "";
//                total_keywords_a[142] = "";
//                total_keywords_a[143] = "";
//                total_keywords_a[144] = "";
//                total_keywords_a[145] = "";
//                total_keywords_a[146] = "";
//                total_keywords_a[147] = "";
//                total_keywords_a[148] = "";
//                total_keywords_a[149] = "";
//                total_keywords_a[150] = "";
//                total_keywords_a[151] = "";
//                total_keywords_a[152] = "";
//                total_keywords_a[153] = "";
//                total_keywords_a[154] = "";
//                total_keywords_a[155] = "";
//                total_keywords_a[156] = "";
//                total_keywords_a[157] = "";
//                total_keywords_a[158] = "";
//                total_keywords_a[159] = "";
//                total_keywords_a[160] = "";
//                total_keywords_a[161] = "";
//                total_keywords_a[162] = "";
//                total_keywords_a[163] = "";
//                total_keywords_a[164] = "";
//                total_keywords_a[165] = "";
//                total_keywords_a[166] = "";
//                total_keywords_a[167] = "";
//                total_keywords_a[168] = "";
//                total_keywords_a[169] = "";
//                total_keywords_a[170] = "";
//                total_keywords_a[171] = "";
//                total_keywords_a[172] = "";
//                total_keywords_a[173] = "";
//                total_keywords_a[174] = "";
//                total_keywords_a[175] = "";
//                total_keywords_a[176] = "";
//                total_keywords_a[177] = "";
//                total_keywords_a[178] = "";
//                total_keywords_a[179] = "";
//                total_keywords_a[180] = "";
//                total_keywords_a[181] = "";
//                total_keywords_a[182] = "";
//                total_keywords_a[183] = "";
//                total_keywords_a[184] = "";
//                total_keywords_a[185] = "";
//                total_keywords_a[186] = "";
//                total_keywords_a[187] = "";
//                total_keywords_a[188] = "";
//                total_keywords_a[189] = "";
//                total_keywords_a[190] = "";
//                total_keywords_a[191] = "";
//                total_keywords_a[192] = "";
//                total_keywords_a[193] = "";
//                total_keywords_a[194] = "";
//                total_keywords_a[195] = "";
//                total_keywords_a[196] = "";
//                total_keywords_a[197] = "";
//                total_keywords_a[198] = "";
//                total_keywords_a[199] = "";
//                total_keywords_a[200] = "";
//                total_keywords_a[201] = "";
//                total_keywords_a[202] = "";
//                total_keywords_a[203] = "";
//                total_keywords_a[204] = "";
//                total_keywords_a[205] = "";
//                total_keywords_a[206] = "";
//                total_keywords_a[207] = "";
//                total_keywords_a[208] = "";
//                total_keywords_a[209] = "";
//                total_keywords_a[210] = "";
//                total_keywords_a[211] = "";
//                total_keywords_a[212] = "";
//                total_keywords_a[213] = "";
//                total_keywords_a[214] = "";
//                total_keywords_a[215] = "";
//                total_keywords_a[216] = "";
//                total_keywords_a[217] = "";
//                total_keywords_a[218] = "";
//                total_keywords_a[219] = "";
//                total_keywords_a[220] = "";
//                total_keywords_a[221] = "";
//                total_keywords_a[222] = "";
//                total_keywords_a[223] = "";
//                total_keywords_a[224] = "";
//                total_keywords_a[225] = "";
//                total_keywords_a[226] = "";
//                total_keywords_a[227] = "";
//                total_keywords_a[228] = "";
//                total_keywords_a[229] = "";
//                total_keywords_a[230] = "";
//                total_keywords_a[231] = "";
//                total_keywords_a[232] = "";
//                total_keywords_a[233] = "";
//                total_keywords_a[234] = "";
//                total_keywords_a[235] = "";
//                total_keywords_a[236] = "";
//                total_keywords_a[237] = "";
//                total_keywords_a[238] = "";
//                total_keywords_a[239] = "";
//                total_keywords_a[240] = "";
//                total_keywords_a[241] = "";
//                total_keywords_a[242] = "";
//                total_keywords_a[243] = "";
//                total_keywords_a[244] = "";
//                total_keywords_a[245] = "";
//                total_keywords_a[246] = "";
//                total_keywords_a[247] = "";
//                total_keywords_a[248] = "";
//                total_keywords_a[249] = "";
//                total_keywords_a[250] = "";
//                total_keywords_a[251] = "";
//                total_keywords_a[252] = "";
//                total_keywords_a[253] = "";
//                total_keywords_a[254] = "";
//                total_keywords_a[255] = "";
//                total_keywords_a[256] = "";
//                total_keywords_a[257] = "";
//                total_keywords_a[258] = "";
//                total_keywords_a[259] = "";
//                total_keywords_a[260] = "";
//                total_keywords_a[261] = "";
//                total_keywords_a[262] = "";
//                total_keywords_a[263] = "";
//                total_keywords_a[264] = "";
//                total_keywords_a[265] = "";
//                total_keywords_a[266] = "";
//                total_keywords_a[267] = "";
//                total_keywords_a[268] = "";
//                total_keywords_a[269] = "";
//                total_keywords_a[270] = "";
//                total_keywords_a[271] = "";
//                total_keywords_a[272] = "";
//                total_keywords_a[273] = "";
//                total_keywords_a[274] = "";
//                total_keywords_a[275] = "";
//                total_keywords_a[276] = "";
//                total_keywords_a[277] = "";
//                total_keywords_a[278] = "";
//                total_keywords_a[279] = "";
//                total_keywords_a[280] = "";
//                total_keywords_a[281] = "";
//                total_keywords_a[282] = "";
//                total_keywords_a[283] = "";
//                total_keywords_a[284] = "";
//                total_keywords_a[285] = "";
//                total_keywords_a[286] = "";
//                total_keywords_a[287] = "";
//                total_keywords_a[288] = "";
//                total_keywords_a[289] = "";
//                total_keywords_a[290] = "";
//                total_keywords_a[291] = "";
//                total_keywords_a[292] = "";
//                total_keywords_a[293] = "";
//                total_keywords_a[294] = "";
//                total_keywords_a[295] = "";
//                total_keywords_a[296] = "";
//                total_keywords_a[297] = "";
//                total_keywords_a[298] = "";
//                total_keywords_a[299] = "";
//                total_keywords_a[300] = "";
//                total_keywords_a[301] = "";
//                total_keywords_a[302] = "";
//                total_keywords_a[303] = "";
//                total_keywords_a[304] = "";
//                total_keywords_a[305] = "";
//                total_keywords_a[306] = "";
//                total_keywords_a[307] = "";
//                total_keywords_a[308] = "";
//                total_keywords_a[309] = "";
//                total_keywords_a[310] = "";
//                total_keywords_a[311] = "";
//                total_keywords_a[312] = "";
//                total_keywords_a[313] = "";
//                total_keywords_a[314] = "";
//                total_keywords_a[315] = "";
//                total_keywords_a[316] = "";
//                total_keywords_a[317] = "";
//                total_keywords_a[318] = "";
//                total_keywords_a[319] = "";
//                total_keywords_a[320] = "";
//                total_keywords_a[321] = "";
//                total_keywords_a[322] = "";
//                total_keywords_a[323] = "";
//                total_keywords_a[324] = "";
//                total_keywords_a[325] = "";
//                total_keywords_a[326] = "";
//                total_keywords_a[327] = "";
//                total_keywords_a[328] = "";
//                total_keywords_a[329] = "";
//                total_keywords_a[330] = "";
//                total_keywords_a[331] = "";
//                total_keywords_a[332] = "";
//                total_keywords_a[333] = "";
//                total_keywords_a[334] = "";
//                total_keywords_a[335] = "";
//                total_keywords_a[336] = "";
//                total_keywords_a[337] = "";
//                total_keywords_a[338] = "";
//                total_keywords_a[339] = "";
//                total_keywords_a[340] = "";
//                total_keywords_a[341] = "";
//                total_keywords_a[342] = "";
//                total_keywords_a[343] = "";
//                total_keywords_a[344] = "";
//                total_keywords_a[345] = "";
//                total_keywords_a[346] = "";
//                total_keywords_a[347] = "";
//                total_keywords_a[348] = "";
//                total_keywords_a[349] = "";
//                total_keywords_a[350] = "";
//                total_keywords_a[351] = "";
//                total_keywords_a[352] = "";
//                total_keywords_a[353] = "";
//                total_keywords_a[354] = "";
//                total_keywords_a[355] = "";
//                total_keywords_a[356] = "";
//                total_keywords_a[357] = "";
//                total_keywords_a[358] = "";
//                total_keywords_a[359] = "";
//                total_keywords_a[360] = "";
//                total_keywords_a[361] = "";
//                total_keywords_a[362] = "";
//                total_keywords_a[363] = "";
//                total_keywords_a[364] = "";
//                total_keywords_a[365] = "";
//                total_keywords_a[366] = "";
//                total_keywords_a[367] = "";
//                total_keywords_a[368] = "";
//                total_keywords_a[369] = "";
//                total_keywords_a[370] = "";
//                total_keywords_a[371] = "";
//                total_keywords_a[372] = "";
//                total_keywords_a[373] = "";
//                total_keywords_a[374] = "";
//                total_keywords_a[375] = "";
//                total_keywords_a[376] = "";
//                total_keywords_a[377] = "";
//                total_keywords_a[378] = "";
//                total_keywords_a[379] = "";
//                total_keywords_a[380] = "";
//                total_keywords_a[381] = "";
//                total_keywords_a[382] = "";
//                total_keywords_a[383] = "";
//                total_keywords_a[384] = "";
//                total_keywords_a[385] = "";
//                total_keywords_a[386] = "";
//                total_keywords_a[387] = "";
//                total_keywords_a[388] = "";
//                total_keywords_a[389] = "";
//                total_keywords_a[390] = "";
//                total_keywords_a[391] = "";
//                total_keywords_a[392] = "";
//                total_keywords_a[393] = "";
//                total_keywords_a[394] = "";
//                total_keywords_a[395] = "";
//                total_keywords_a[396] = "";
//                total_keywords_a[397] = "";
//                total_keywords_a[398] = "";
//                total_keywords_a[399] = "";
//                total_keywords_a[400] = "";
//                total_keywords_a[401] = "";
//                total_keywords_a[402] = "";
//                total_keywords_a[403] = "";
//                total_keywords_a[404] = "";
//                total_keywords_a[405] = "";
//                total_keywords_a[406] = "";
//                total_keywords_a[407] = "";
//                total_keywords_a[408] = "";
//                total_keywords_a[409] = "";
//                total_keywords_a[410] = "";
//                total_keywords_a[411] = "";
//                total_keywords_a[412] = "";
//                total_keywords_a[413] = "";
//                total_keywords_a[414] = "";
//                total_keywords_a[415] = "";
//                total_keywords_a[416] = "";
//                total_keywords_a[417] = "";
//                total_keywords_a[418] = "";
//                total_keywords_a[419] = "";
//                total_keywords_a[420] = "";
//                total_keywords_a[421] = "";
//                total_keywords_a[422] = "";
//                total_keywords_a[423] = "";
//                total_keywords_a[424] = "";
//                total_keywords_a[425] = "";
//                total_keywords_a[426] = "";
//                total_keywords_a[427] = "";
//                total_keywords_a[428] = "";
//                total_keywords_a[429] = "";
//                total_keywords_a[430] = "";
//                total_keywords_a[431] = "";
//                total_keywords_a[432] = "";
//                total_keywords_a[433] = "";
//                total_keywords_a[434] = "";
//                total_keywords_a[435] = "";
//                total_keywords_a[436] = "";
//                total_keywords_a[437] = "";
//                total_keywords_a[438] = "";
//                total_keywords_a[439] = "";
//                total_keywords_a[440] = "";
//                total_keywords_a[441] = "";
//                total_keywords_a[442] = "";
//                total_keywords_a[443] = "";
//                total_keywords_a[444] = "";
//                total_keywords_a[445] = "";
//                total_keywords_a[446] = "";
//                total_keywords_a[447] = "";
//                total_keywords_a[448] = "";
//                total_keywords_a[449] = "";
//                total_keywords_a[450] = "";
//                total_keywords_a[451] = "";
//                total_keywords_a[452] = "";
//                total_keywords_a[453] = "";
//                total_keywords_a[454] = "";
//                total_keywords_a[455] = "";
//                total_keywords_a[456] = "";
//                total_keywords_a[457] = "";
//                total_keywords_a[458] = "";
//                total_keywords_a[459] = "";
//                total_keywords_a[460] = "";
//                total_keywords_a[461] = "";
//                total_keywords_a[462] = "";
//                total_keywords_a[463] = "";
//                total_keywords_a[464] = "";
//                total_keywords_a[465] = "";
//                total_keywords_a[466] = "";
//                total_keywords_a[467] = "";
//                total_keywords_a[468] = "";
//                total_keywords_a[469] = "";
//                total_keywords_a[470] = "";
//                total_keywords_a[471] = "";
//                total_keywords_a[472] = "";
//                total_keywords_a[473] = "";
//                total_keywords_a[474] = "";
//                total_keywords_a[475] = "";
//                total_keywords_a[476] = "";
//                total_keywords_a[477] = "";
//                total_keywords_a[478] = "";
//                total_keywords_a[479] = "";
//                total_keywords_a[480] = "";
//                total_keywords_a[481] = "";
//                total_keywords_a[482] = "";
//                total_keywords_a[483] = "";
//                total_keywords_a[484] = "";
//                total_keywords_a[485] = "";
//                total_keywords_a[486] = "";
//                total_keywords_a[487] = "";
//                total_keywords_a[488] = "";
//                total_keywords_a[489] = "";
//                total_keywords_a[490] = "";
//                total_keywords_a[491] = "";
//                total_keywords_a[492] = "";
//                total_keywords_a[493] = "";
//                total_keywords_a[494] = "";
//                total_keywords_a[495] = "";
//                total_keywords_a[496] = "";
//                total_keywords_a[497] = "";
//                total_keywords_a[498] = "";
//                total_keywords_a[499] = "";
//                total_keywords_a[500] = "";
//                total_keywords_a[501] = "";
//                total_keywords_a[502] = "";
//                total_keywords_a[503] = "";
//                total_keywords_a[504] = "";
//                total_keywords_a[505] = "";
//                total_keywords_a[506] = "";
//                total_keywords_a[507] = "";
//                total_keywords_a[508] = "";
//                total_keywords_a[509] = "";
//                total_keywords_a[510] = "";
//                total_keywords_a[511] = "";
//                total_keywords_a[512] = "";
//                total_keywords_a[513] = "";
//                total_keywords_a[514] = "";
//                total_keywords_a[515] = "";
//                total_keywords_a[516] = "";
//                total_keywords_a[517] = "";
//                total_keywords_a[518] = "";
//                total_keywords_a[519] = "";
//                total_keywords_a[520] = "";
//                total_keywords_a[521] = "";
//                total_keywords_a[522] = "";
//                total_keywords_a[523] = "";
//                total_keywords_a[524] = "";
//                total_keywords_a[525] = "";
//                total_keywords_a[526] = "";
//                total_keywords_a[527] = "";
//                total_keywords_a[528] = "";
//                total_keywords_a[529] = "";
//                total_keywords_a[530] = "";
//                total_keywords_a[531] = "";
//                total_keywords_a[532] = "";
//                total_keywords_a[533] = "";
//                total_keywords_a[534] = "";
//                total_keywords_a[535] = "";
//                total_keywords_a[536] = "";
//                total_keywords_a[537] = "";
//                total_keywords_a[538] = "";
//                total_keywords_a[539] = "";
//                total_keywords_a[540] = "";
//                total_keywords_a[541] = "";
//                total_keywords_a[542] = "";
//                total_keywords_a[543] = "";
//                total_keywords_a[544] = "";
//                total_keywords_a[545] = "";
//                total_keywords_a[546] = "";
//                total_keywords_a[547] = "";
//                total_keywords_a[548] = "";
//                total_keywords_a[549] = "";
//

                //keywords are extracted from Title, Headers(h1 to h6), ALT values, Highlighted text


                total_keywords_count = img_alt_count_size + links_count + h1_twords + h2_twords + h3_twords + h4_twords + h5_twords + h6_twords + title_word_count;

                keywords_report = "The site contains at least " + total_keywords_count + " Keywords in total.\nThe keywords are as follows: \n\n\n";
                int ws_keywords_count=0;

                if(title_word_count>0){
                    for(int i = 0;i<title_word_count; i=i+3){
                        if(title_keywords_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+title_keywords_a[i]+" , "+title_keywords_a[i+1]+" , "+title_keywords_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(links_count>0){
                    for(int i = 0;i<links_count;++i){
                        if(highlighted_text_str_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+highlighted_text_str_a[i]+" , "+highlighted_text_str_a[i+1]+" , "+highlighted_text_str_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(img_alt_count_size>0){
                    for(int i = 0;i<img_alt_count_size;++i){
                        if(img_alt_value[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+img_alt_value[i]+" , "+img_alt_value[i+1]+" , "+img_alt_value[i+2];
                    }
                    keywords_report+="\n";
                }
                if(h1_twords>0){
                    for(int i = 0;i<h1_twords;++i){
                        if(h1_total_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+h1_total_a[i]+" , "+h1_total_a[i+1]+" , "+h1_total_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(h2_twords>0){
                    for(int i = 0;i<h2_twords;++i){
                        if(h2_total_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+h2_total_a[i]+" , "+h2_total_a[i+1]+" , "+h2_total_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(h3_twords>0){
                    for(int i = 0;i<h3_twords;++i){
                        if(h3_total_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+h3_total_a[i]+" , "+h3_total_a[i+1]+" , "+h3_total_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(h4_twords>0){
                    for(int i = 0;i<h4_twords;++i){
                        if(h4_total_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+h4_total_a[i]+" , "+h4_total_a[i+1]+" , "+h4_total_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(h5_twords>0){
                    for(int i = 0;i<h5_twords;++i){
                        if(h5_total_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+h5_total_a[i]+" , "+h5_total_a[i+1]+" , "+h5_total_a[i+2];
                    }
                    keywords_report+="\n";
                }
                if(h6_twords>0){
                    for(int i = 0;i<h6_twords;++i){
                        if(h6_total_a[i]==" ")
                            ws_keywords_count+=1;

                        keywords_report+="\n\t\t- "+h6_total_a[i]+" , "+h6_total_a[i+1]+" , "+h6_total_a[i+2];
                    }
                    keywords_report+="\n";
                }

                keywords_report+="\n---------------------------------------------------------------------------------------------\nThe site has used "+ws_keywords_count+" whitespaces in place of keywords unnecessarily. ..";



            }

//Meta meta_keywords_string, meta_author_string, meta_description_string, meta_viewport_string, rel_canonical      presents
            if(url_valid_on_bool==true){
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                Elements metaTags = document.getElementsByTag("meta");

                for (Element metaTag : metaTags) {
                    String content = metaTag.attr("content");
                    String name = metaTag.attr("name");

                    meta_description_tags_size = document.select("meta[name~=(description|Description)]").size();
                    meta_keywords_size = document.select("meta[name~=(keywords|Keywords)]").size();
                    meta_robots_size = document.select("meta[name~=(robots|Robots)]").size();
                    meta_view_port_size = document.select("meta[name~=(viewport|Viewport)]").size();
                    link_rel_canonical_tag_size = document.select("link[rel~=(canonical|Canonical)]").size();
                    meta_author_size = document.select("meta[name~=(author|Author)]").size();

                    if(meta_robots_size>0){
                        meta_robots_bool=true;
                    }if(meta_description_tags_size>0){
                        meta_description_tags_bool=true;
                    }if(meta_keywords_size>0){
                        meta_keywords_bool=true;
                    }if(meta_view_port_size>0){
                        meta_view_port_bool=true;
                    }if(link_rel_canonical_tag_size>0){
                        link_rel_canonical_tag_bool=true;
                    }if(meta_author_size>0){
                        meta_author_bool=true;
                    }




                    if("description".equals(name)) {
                        meta_description_string = content;
                        strovvhead_metaDescrpsn="Meta Description Exists !";
                        strovvbody_metaDescrpsn=content;
                    }if("Description".equals(name)) {
                        meta_description_string = content;
                        strovvhead_metaDescrpsn="Meta Description Exists !";
                        strovvbody_metaDescrpsn=content;
                    }

                    if("keywords".equals(name)) {
                        meta_keywords_string = content;
                        strovvhead_MetaKeywords="Meta Keywords Exists !";
                        strovvbody_MetaKeywords=content;
                    }if("Keywords".equals(name)) {
                        meta_keywords_string = content;
                        strovvhead_MetaKeywords="Meta Keywords Exists !";
                        strovvbody_MetaKeywords=content;
                    }

                    if("author".equals(name)) {
                        meta_author_string = content;
                        strovvhead_MEtaAuthor="Meta Author Exists !";
                        strovvbody_MEtaAuthor=content;
                    }if("Author".equals(name)) {
                        meta_author_string = content;
                        strovvhead_MEtaAuthor="Meta Author Exists !";
                        strovvbody_MEtaAuthor=content;
                    }

                    if("viewport".equals(name)) {
                        meta_viewport_string = content;

                        strovvhead_ViewPort="Meta View Port Exists !";
                        strovvbody_ViewPort=content;
                    }if("Viewport".equals(name)) {
                        meta_viewport_string = content;
                        strovvhead_ViewPort="Meta View Port Exists !";
                        strovvbody_ViewPort=content;
                    }

                    if("robots".equals(name)) {
                        meta_robots_string = content;
                        strovvhead_Robots="Meta Robots.txt Exists !";
                        strovvbody_Robots=content;
                    }if("Robots".equals(name)) {
                        meta_robots_string = content;
                        strovvhead_Robots="Meta Robots.txt Exists !";
                        strovvbody_Robots=content;
                    }

                }
                Elements links = document.getElementsByTag("link");
                for(Element link: links){
                    String content = link.attr("href");
                    String name =  link.attr("rel");

                    if("Canonical".equals(name)){
                        rel_canonical_report_string = content;
                        strovvhead_RelLinkCanonical="Rel Link Canonical Exists !";
                        strovvbody_RelLinkCanonical=content;
                    }if("canonical".equals(name)){
                        rel_canonical_report_string = content;
                        strovvhead_RelLinkCanonical="Rel Link Canonical Exists !";
                        strovvbody_RelLinkCanonical=content;
                    }
                }

                if(link_rel_canonical_tag_bool){
                    rel_canonical_report="link rel=\"canonical\" tag exists.\nVALUE: "+rel_canonical_report_string;
                    bool_ovv6relCanonical=true;
                }else{
                    rel_canonical_report="link rel=\"canonical\" tag doesn't Exist !";
                    bool_ovv6relCanonical=false;
                }
                if(meta_description_tags_bool==true){
                    meta_description_report="Meta Description Exists; \n"+"VALUE: "+meta_description_string;
                    bool_ovv3metaDescipt=true;
                }else{
                    meta_description_report="Meta Description doesn't Exist !";
                    bool_ovv3metaDescipt=false;
                }
                if(meta_keywords_bool==true){
                    meta_keywords_report="Meta Keywords Exists; \n"+"VALUE: "+meta_keywords_string;
                    bool_ovv8metaKeywords=true;
                }else{
                    meta_keywords_report="Meta Keywords doesn't Exist !";
                    bool_ovv8metaKeywords=false;
                }
                if(meta_author_bool==true){
                    meta_author_report="Meta Author Exists; \n"+"VALUE: "+meta_author_string;
                    bool_ovv7metaAuthor=true;
                }else{
                    meta_author_report="Meta Author doesn't Exist !";
                    bool_ovv7metaAuthor=false;
                }
                if(meta_robots_bool==true){
                    meta_robots_report="Meta Robots Exists; \n"+"VALUE: "+meta_robots_string;
                    bool_ovv4metaRobots=true;
                }else{
                    meta_robots_report="Meta Robots doesn't Exist !";
                    bool_ovv4metaRobots=false;
                }
                if(meta_view_port_bool==true){
                    meta_viewport_report="Meta View Port Exists; \n"+"VALUE: "+meta_viewport_string;
                    bool_ovv5metaViewPort=true;
                }else{
                    meta_viewport_report="Meta View Port doesn't Exist !";
                    bool_ovv5metaViewPort=false;
                }


            }

//Page Favicon
            int favicon_Size=0;
            if(url_valid_on_bool==true){
                org.jsoup.nodes.Document document = Jsoup.parse(html_string);
                Element element = document.head().select("link[href~=.*\\.(ico|png)]").first();
                page_favicon_report=" ";
                try{
                    page_favicon_report=element.attr("href");

                }catch(NullPointerException e){
                    page_favicon_report=e.toString();

                }
                favicon_Size = document.select("link[name=icon]").size();

                if(favicon_Size>0){
                    page_favicon_report="Page Favicon Exists &\nLINK: "+page_favicon_report;
                    bool_favicon=true;
                }
                else{
                    page_favicon_report="PAge Favicon Doesn't Exist !";
                    bool_favicon=false;
                }
            }

            //Page Report
            if(url_valid_on_bool==true){
                //title
                //meta description
                //meta keyword
                //meta author
                //meta viewport
                //meta robots
                //h1
                //h2
                //h3
                //h4
                //h5
                //h6
                //ALT attribute if <img> tag is yaobzz
                //page favicon
                //Suggestion: Include all the relevant keywords, be it Exact Match, Long Tail, or a Latent Semantic Index(LSI)\ninside the Meta Keywords tag, The Title tag, from h1 to h6 tags, & ALt attribute.
                string_seo_page_full_report="...";

                if(title_char_count>0){
                    string_seo_page_full_report="1. Title Tag Exists.\n ";
                }else{
                    string_seo_page_full_report="1. Title Tag doesn't Exist.\n ";

                }
                if(meta_description_tags_bool==false){
                    string_seo_page_full_report+="\n2. Meta Description Tag doesn't Exist.\n ";
                }else{
                    string_seo_page_full_report+="\n2. Meta Description Tag Exists.\n  ";

                }
                if(meta_keywords_bool==false){
                    string_seo_page_full_report+="\n3. Meta Keywords Tag doesn't Exist.\n  ";

                }else{
                    string_seo_page_full_report+="\n3. Meta Keywords Tag Exists.\n  ";

                }
                if(meta_author_bool==false){
                    string_seo_page_full_report+="\n4. Meta Author Tag doesn't Exist.  ";

                }else{
                    string_seo_page_full_report+="\n4. Meta Author Tag Exists.  ";
                }
                if(meta_view_port_bool==false){
                    string_seo_page_full_report+="\n\n5. Meta Viewport Tag doesn't Exist.  ";

                }else{
                    string_seo_page_full_report+="\n\n5. Meta Viewport Tag Exists.  ";

                }
                if(meta_robots_bool==false){
                    string_seo_page_full_report+="\n\n6. Meta Robots Tag doesn't Exist.  ";

                }else{
                    string_seo_page_full_report+="\n\n6. Meta Robots Tag Exists.  ";

                }
                if(h1_bool==false){
                    string_seo_page_full_report+="\n\n7. H1 Tag doesn't Exist.  ";
                }else{
                    string_seo_page_full_report+="\n\n7. H1 Tag Exist.  ";
                }
                if(h2_bool==false){
                    string_seo_page_full_report+="\n\n8. H2 Tag doesn't Exist.  ";
                }else{
                    string_seo_page_full_report+="\n\n8. H2 Tag Exist.  ";
                }
                if(h3_bool==false){
                    string_seo_page_full_report+="\n\n9. H3 Tag doesn't Exist.  ";
                }else{
                    string_seo_page_full_report+="\n\n9. H3 Tag Exist.  ";
                }
                if(h4_bool==false){
                    string_seo_page_full_report+="\n\n10. H4 Tag doesn't Exist.  ";
                }else{
                    string_seo_page_full_report+="\n\n10. H4 Tag Exist.  ";
                }
                if(h5_bool==false){
                    string_seo_page_full_report+="\n\n11. H5 Tag doesn't Exist.  ";
                }else{
                    string_seo_page_full_report+="\n\n11. H5 Tag Exists.  ";
                }
                if(h6_bool==false){
                    string_seo_page_full_report+="\n\n12. H6 Tag doesn't Exist.  ";
                }else{
                    string_seo_page_full_report+="\n\n12. H6 Tag Exists.  ";
                }
                if(img_count_size>0){
                    string_seo_page_full_report+="\n\n13. <img> Tag Exists. We Consider You Look Below the Reports for more details on the Presence of Alt Attribute or not. ";

                }
                if(favicon_Size>0){//favicon size refers to the number of favicon tags not the Favicon Image Resolution
                    string_seo_page_full_report+="\n\n13. Favicon Element Exist. Great! ";
                }else{
                    string_seo_page_full_report+="\n\n13. Page Favicon does not Exist. \n\tWe recommend you include a favicon image. ";
                }
                string_seo_page_full_report+="\n\n\nThat's the End of the report. The above specified tags are the Important SEO tags you need to include in your website. \n\nIf the tags aren't present on your site, include it fastly with keywords and relevant texts by searching through the Keyword Research Tool (KRT) which can be seen on the next tab.\n\n\nAbout the page content/information, we recommend you to make it Lengthy as possible categorised using h1 to h6 tags.\n\nMake the contents easier for the users to be accessed. ANd, don't forget to put your name on the Author Meta Tag. That's all. SEO is Easy as that. ";





            }
            else{
                string_seo_page_full_report="Dear User, please do enter a Valid URL.";
            }





//            Toast.makeText(getApplicationContext(), "Please Wait !", Toast.LENGTH_LONG).show();

            return null;
        }
        @Override
        protected void onPostExecute (Void result){
            progressDialog.hide();
//                Toast.makeText(getApplicationContext(), "Ready to Display !", Toast.LENGTH_LONG).show();

            //if url is valid
            if(url_valid_on_bool==true){

                textView_keywords.setText(keywords_report);
                cl_scoreanalysis.setVisibility(View.VISIBLE);
//Overview      TextView(s).setText(txtString);
                if(bool_ovv1urlreport==true){
                    TVhead_ovv1.setText(strovvhead_url);
                    TV_bodyovv1.setText(strovvbody_url);
                    IVtick_ovv1.setVisibility(View.VISIBLE);
                    IVcross_ovv1.setVisibility(View.GONE);
                }else{
                    TVhead_ovv1.setText(strovvhead_url);
                    TV_bodyovv1.setText(strovvbody_url);
                    IVtick_ovv1.setVisibility(View.GONE);
                    IVcross_ovv1.setVisibility(View.VISIBLE);
                }
                if(bool_ovv2title==true){
                    TVhead_ovv3.setText(strovvhead_title);
                    TV_bodyovv3.setText(strovvbody_title);
                    IVtick_ovv3.setVisibility(View.VISIBLE);
                    IVcross_ovv3.setVisibility(View.GONE);

                }else{
                    TVhead_ovv3.setText(strovvhead_title);
                    TV_bodyovv3.setText(strovvbody_title);
                    IVtick_ovv3.setVisibility(View.GONE);
                    IVcross_ovv3.setVisibility(View.VISIBLE);
                }
                if(bool_ovv3metaDescipt==true){
                    TVhead_ovv4.setText(strovvhead_metaDescrpsn);
                    TV_bodyovv4.setText(strovvbody_metaDescrpsn);
                    IVtick_ovv4.setVisibility(View.VISIBLE);
                    IVcross_ovv4.setVisibility(View.GONE);

                }else{
                    TVhead_ovv4.setText(strovvhead_metaDescrpsn);
                    TV_bodyovv4.setText(strovvbody_metaDescrpsn);
                    IVtick_ovv4.setVisibility(View.GONE);
                    IVcross_ovv4.setVisibility(View.VISIBLE);
                }
                if(bool_ovv4metaRobots==true){
                    TVhead_ovv5.setText(strovvhead_Robots);
                    TV_bodyovv5.setText(strovvbody_Robots);
                    IVtick_ovv5.setVisibility(View.VISIBLE);
                    IVcross_ovv5.setVisibility(View.GONE);

                }else{
                    TVhead_ovv5.setText(strovvhead_Robots);
                    TV_bodyovv5.setText(strovvbody_Robots);
                    IVtick_ovv5.setVisibility(View.GONE);
                    IVcross_ovv5.setVisibility(View.VISIBLE);
                }
                if(bool_ovv5metaViewPort==true){
                    TVhead_ovv6.setText(strovvhead_ViewPort);
                    TV_bodyovv6.setText(strovvbody_ViewPort);
                    IVtick_ovv6.setVisibility(View.VISIBLE);
                    IVcross_ovv6.setVisibility(View.GONE);

                }else{
                    TVhead_ovv6.setText(strovvhead_ViewPort);
                    TV_bodyovv6.setText(strovvbody_ViewPort);
                    IVtick_ovv6.setVisibility(View.GONE);
                    IVcross_ovv6.setVisibility(View.VISIBLE);
                }
                if(bool_ovv6relCanonical==true){
                    TVhead_ovv7.setText(strovvhead_RelLinkCanonical);
                    TV_bodyovv7.setText(strovvbody_RelLinkCanonical);
                    IVtick_ovv7.setVisibility(View.VISIBLE);
                    IVcross_ovv7.setVisibility(View.GONE);

                }else{
                    TVhead_ovv7.setText(strovvhead_RelLinkCanonical);
                    TV_bodyovv7.setText(strovvbody_RelLinkCanonical);
                    IVtick_ovv7.setVisibility(View.GONE);
                    IVcross_ovv7.setVisibility(View.VISIBLE);
                }
                if(bool_ovv7metaAuthor==true){
                    TVhead_ovv8.setText(strovvhead_MEtaAuthor);
                    TV_bodyovv8.setText(strovvbody_MEtaAuthor);
                    IVtick_ovv8.setVisibility(View.VISIBLE);
                    IVcross_ovv8.setVisibility(View.GONE);

                }else{
                    TVhead_ovv8.setText(strovvhead_MEtaAuthor);
                    TV_bodyovv8.setText(strovvbody_MEtaAuthor);
                    IVtick_ovv8.setVisibility(View.GONE);
                    IVcross_ovv8.setVisibility(View.VISIBLE);
                }
                if(bool_ovv8metaKeywords==true){
                    TVhead_ovv9.setText(strovvhead_MetaKeywords);
                    TV_bodyovv9.setText(strovvbody_MetaKeywords);
                    IVtick_ovv9.setVisibility(View.VISIBLE);
                    IVcross_ovv9.setVisibility(View.GONE);

                }else{
                    TVhead_ovv9.setText(strovvhead_MetaKeywords);
                    TV_bodyovv9.setText(strovvbody_MetaKeywords);
                    IVtick_ovv9.setVisibility(View.GONE);
                    IVcross_ovv9.setVisibility(View.VISIBLE);
                }
                if(bool_hdrs1==true){

                    //overview
                    TVhead_ovv10.setText(strovvhead_H1);
                    TV_bodyovv10.setText(strovvbody_H1);
                    IVtick_ovv10.setVisibility(View.VISIBLE);
                    IVcross_ovv10.setVisibility(View.GONE);
                    //headers
                    TVhead_hdrs1.setText(strovvhead_H1);
                    TV_bodyhdrs1.setText(strovvbody_H1);
                    IVtick_hdrs1.setVisibility(View.VISIBLE);
                    IVcross_hdrs1.setVisibility(View.GONE);
                }else{
                    //overview
                    TVhead_ovv10.setText(strovvhead_H1);
                    TV_bodyovv10.setText(strovvbody_H1);
                    IVtick_ovv10.setVisibility(View.GONE);
                    IVcross_ovv10.setVisibility(View.VISIBLE);
                    //headers
                    TVhead_hdrs1.setText(strovvhead_H1);
                    TV_bodyhdrs1.setText(strovvbody_H1);
                    IVtick_hdrs1.setVisibility(View.GONE);
                    IVcross_hdrs1.setVisibility(View.VISIBLE);
                }
                if(bool_hdrs2==true){
                    //overview
                    TVhead_ovv11.setText(strovvhead_H2);
                    TV_bodyovv11.setText(strovvbody_H2);
                    IVtick_ovv11.setVisibility(View.VISIBLE);
                    IVcross_ovv11.setVisibility(View.GONE);
                    //headers
                    TVhead_hdrs3.setText(strovvhead_H2);
                    TV_bodyhdrs3.setText(strovvbody_H2);
                    IVtick_hdrs3.setVisibility(View.VISIBLE);
                    IVcross_hdrs3.setVisibility(View.GONE);
                }else{
                    TVhead_ovv11.setText(strovvhead_H2);
                    TV_bodyovv11.setText(strovvbody_H2);
                    IVtick_ovv11.setVisibility(View.GONE);
                    IVcross_ovv11.setVisibility(View.VISIBLE);
                    TVhead_hdrs3.setText(strovvhead_H2);
                    TV_bodyhdrs3.setText(strovvbody_H2);
                    IVtick_hdrs3.setVisibility(View.GONE);
                    IVcross_hdrs3.setVisibility(View.VISIBLE);
                }
                if(bool_hdrs3==true){
                    //overview
                    TVhead_ovv12.setText(strovvhead_H3);
                    TV_bodyovv12.setText(strovvbody_H3);
                    IVtick_ovv12.setVisibility(View.VISIBLE);
                    IVcross_ovv12.setVisibility(View.GONE);
                    //headers
                    TVhead_hdrs4.setText(strovvhead_H3);
                    TV_bodyhdrs4.setText(strovvbody_H3);
                    IVtick_hdrs4.setVisibility(View.VISIBLE);
                    IVcross_hdrs4.setVisibility(View.GONE);
                }else{
                    //overview
                    TVhead_ovv12.setText(strovvhead_H3);
                    TV_bodyovv12.setText(strovvbody_H3);
                    IVtick_ovv12.setVisibility(View.GONE);
                    IVcross_ovv12.setVisibility(View.VISIBLE);
                    //headers
                    TVhead_hdrs4.setText(strovvhead_H3);
                    TV_bodyhdrs4.setText(strovvbody_H3);
                    IVtick_hdrs4.setVisibility(View.GONE);
                    IVcross_hdrs4.setVisibility(View.VISIBLE);

                }
                if(bool_ovv12Links==true){
                    TVhead_ovv14.setText(strovvhead_Links);
                    TV_bodyovv14.setText(strovvbody_Links);
                    IVtick_ovv14.setVisibility(View.VISIBLE);
                    IVcross_ovv14.setVisibility(View.GONE);

                }else{
                    TVhead_ovv14.setText(strovvhead_Links);
                    TV_bodyovv14.setText(strovvbody_Links);
                    IVtick_ovv14.setVisibility(View.GONE);
                    IVcross_ovv14.setVisibility(View.VISIBLE);
                }
                if(bool_ovv13imagesAlt==true){
                    TVhead_ovv15.setText(strovvhead_Images);
                    TV_bodyovv15.setText(strovvbody_Images);
                    IVtick_ovv15.setVisibility(View.VISIBLE);
                    IVcross_ovv15.setVisibility(View.GONE);

                }else{
                    TVhead_ovv15.setText(strovvhead_Images);
                    TV_bodyovv15.setText(strovvbody_Images);
                    IVtick_ovv15.setVisibility(View.GONE);
                    IVcross_ovv15.setVisibility(View.VISIBLE);
                }





                //HEader h4, h5, h6
                if(bool_hdrs4){
                    TVhead_hdrs5.setText(strovvhead_H4);
                    TV_bodyhdrs5.setText(strovvbody_H4);
                    IVtick_hdrs5.setVisibility(View.VISIBLE);
                    IVcross_hdrs5.setVisibility(View.GONE);
                }else{
                    TVhead_hdrs5.setText(strovvhead_H4);
                    TV_bodyhdrs5.setText(strovvbody_H4);
                    IVtick_hdrs5.setVisibility(View.GONE);
                    IVcross_hdrs5.setVisibility(View.VISIBLE);
                }
                if(bool_hdrs5){
                    TVhead_hdrs6.setText(strovvhead_H5);
                    TV_bodyhdrs6.setText(strovvbody_H5);
                    IVtick_hdrs6.setVisibility(View.VISIBLE);
                    IVcross_hdrs6.setVisibility(View.GONE);
                }else{
                    TVhead_hdrs6.setText(strovvhead_H5);
                    TV_bodyhdrs6.setText(strovvbody_H5);
                    IVtick_hdrs6.setVisibility(View.GONE);
                    IVcross_hdrs6.setVisibility(View.VISIBLE);
                }
                if(bool_hdrs6){
                    TVhead_hdrs7.setText(strovvhead_H6);
                    TV_bodyhdrs7.setText(strovvbody_H6);
                    IVtick_hdrs7.setVisibility(View.VISIBLE);
                    IVcross_hdrs7.setVisibility(View.GONE);
                }else{
                    TVhead_hdrs7.setText(strovvhead_H6);
                    TV_bodyhdrs7.setText(strovvbody_H6);
                    IVtick_hdrs7.setVisibility(View.GONE);
                    IVcross_hdrs7.setVisibility(View.VISIBLE);
                }



                //html
                tvHTML_opseo.setText(html_string);
                tvBODY_opseo.setText(body_report);
                tvLINKS_opseo.setText(strovvbody_Links);
                tvIMAGESALT_opseo.setText(strovvbody_Images);
                tvFAVICON.setText(page_favicon_report);
                tvREL_LINK_CANONICAL.setText(rel_canonical_report);


                //ScoreCard
                sitename_tv.setText(title_string);

                //make VISIBILITY to the "GONE" for the Views
                cl_scoreLandingPAge.setVisibility(View.GONE);
                cl_compareSites_SEO.setVisibility(View.GONE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_settings.setVisibility(View.GONE);
                cl_leftVertBar.setVisibility(View.GONE);


                tv_metaDescr.setText(meta_description_report);//
                tv_metaRobots.setText(meta_robots_report);//
                tv_metaViewPort.setText(meta_viewport_report);//
                tv_reclCanonicalTag.setText(rel_canonical_report);//
                tv_metaAuthor.setText(meta_author_report);//
                tv_metaKeywords.setText(meta_keywords_report);//

                //View Port
                if(meta_view_port_bool==true){

                    String str_sug_VP = getString(R.string.str_tvSample_onviewport_EXISTS);
                    tv_topSCOREVIEWPORT_VP.setText("(meta-tag) View Port Exists");
                    tv_designation.setText("Nice One !");
                    tv_titleonVP.setText(title_string);
                    tv_sampleRedVP.setText(str_sug_VP);
                }else{
                    String str_sug_VP = getString(R.string.str_tvSample_onviewport_doesntEXISTS);
                    tv_topSCOREVIEWPORT_VP.setText("(meta-tag) View Port doesn't Exist");
                    tv_designation.setText("Needs Work!");
                    tv_titleonVP.setText(title_string);
                    tv_sampleRedVP.setText(str_sug_VP);
                }

            }
            else{
                Toast.makeText(getApplicationContext(), "URL Invalid", Toast.LENGTH_SHORT).show();
                cl_press_back_bottom_bar.setVisibility(View.GONE);
                //cl_main1.setVisibility(View.GONE);
                cl_leftVertBar.setVisibility(View.VISIBLE);
                cl_rightMost_Contianer_4d4LAyouts.setVisibility(View.VISIBLE);
                //Right CL container 4 LAyouts
                //--------------------------------------------------
                cl_scoreLandingPAge.setVisibility(View.VISIBLE);
                cl_compareSites_SEO.setVisibility(View.GONE);
                cl_brokenLinks.setVisibility(View.GONE);
                cl_scoreanalysis.setVisibility(View.GONE);
                cl_settings.setVisibility(View.GONE);
                //Left Vertical ICons Container
                //--------------------------------------------------
                //1 -
                iv_wbckg1.setVisibility(View.INVISIBLE);
                iv_wthoutbckg1.setVisibility(View.VISIBLE);
                //2 -
                iv_wbckg2.setVisibility(View.VISIBLE);
                iv_wthoutbckg2.setVisibility(View.INVISIBLE);
                //3 -
                iv_wbckg3.setVisibility(View.INVISIBLE);
                iv_wthoutbckg3.setVisibility(View.VISIBLE);
                //4 -
                // iv_wbckg4.setVisibility(View.INVISIBLE);
                //iv_wthoutbckg4.setVisibility(View.VISIBLE);
                //5 -
                iv_wbckg5.setVisibility(View.INVISIBLE);
                iv_wthoutbckg5.setVisibility(View.VISIBLE);
                webView_krt.setVisibility(View.GONE);
            //score card
            }

            /*
            textView_on_no_report_page.setVisibility(View.GONE);
            full_report_website_SEO.setVisibility(View.VISIBLE);

            tvBody0.setText(string_seo_page_full_report);
            tvBody1.setText(surl_report);
            tvBody2.setText(html_string);
            tvBody3.setText(title_report);
            tvBody4.setText(headers_report_h1_h6);
            tvBody5.setText(body_report);
            tvBody6.setText(href_strings_report);
            tvBody7.setText(img_report_string);
            tvBody8.setText(keywords_report);
            tvBody9.setText(page_favicon_report);
            tvBody14.setText(meta_description_report);//
            tvBody15.setText(meta_robots_report);//
            tvBody16.setText(meta_viewport_report);//
            tvBody17.setText(rel_canonical_report);//
            tvBody18.setText(meta_author_report);//
            tvBody19.setText(meta_keywords_report);//
*/
        }
    }

    private class SiteLS_asyncCLASS extends AsyncTask<Void, Void, Void>{
        private ProgressDialog SLSprogressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            int_score_general=0;
            int_score_content=0;
            int_score_speed=0;
            int_score_structure=0;

            SLSprogressDialog = new ProgressDialog(MainActivity.this);
            SLSprogressDialog.setMessage("Rasterizing & Setting Views.\nPlease Wait");
            SLSprogressDialog.setIndeterminate(true);
            SLSprogressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
        //General
        //Content
            //1. title
            int_score_general+=1;int_score_content+=0.8;
            //2. meta Description
            if(meta_description_tags_bool){
                int_score_general+=1;int_score_content+=0.125;int_score_structure+=1;
            }
            //3. meta author
            if(meta_author_bool){
                int_score_general+=1;int_score_content+=0.125;int_score_structure+=1;
            }
            //4. keywords meta
            if(meta_keywords_bool){
                int_score_general+=1;int_score_content+=0.8;int_score_structure+=1;
            }
            //5. h1
            if(h1_bool){
                int_score_general+=1;int_score_content+=0.6;int_score_structure+=1.1;
            }
            //6. h2
            if(h2_bool){
                int_score_general+=1;int_score_content+=0.4;int_score_structure+=1.1;
            }
            //7. h3
            if(h3_bool){
                int_score_general+=1;int_score_content+=0.2;int_score_structure+=1.1;
            }
            //8. favicon
            if(bool_favicon){
                int_score_general+=1;
                int_score_content+=0.1;
            }
            //9. robots
            if(meta_robots_bool){
                int_score_general+=1;int_score_structure+=1;
            }
            //10. rel canonical link
            if(link_rel_canonical_tag_bool){
                int_score_general+=1;int_score_structure+=1;
            }
            //11. images
            if(img_tags_bool){
                int_score_general+=1;
                if(imgALT){
                    int_score_content+=0.825;
                }
            }
            //12. view port
            if(meta_view_port_bool){
                int_score_general+=1;int_score_content+=0.3;int_score_structure+=1;
            }
            //13. Links
            if(links_bool){
                int_score_content+=0.825;
            }
            //14. H4
            if(h4_bool){
                int_score_content+=0.4;int_score_structure+=0.8;
            }
            //15. H5
            if(h5_bool){
                int_score_content+=0.3;int_score_structure+=0.6;
            }
            //16. H6
            if(h6_bool){
                int_score_content+=0.2;int_score_structure+=0.5;
            }

        //Speed
            long timeTakeniltsiwv = (long)final_speed_score_in_millis;

            if(timeTakeniltsiwv>0 && timeTakeniltsiwv<1990){
                //perfect
                str_speed_designation="Perfect Load Speed!";
            }else
            if(timeTakeniltsiwv>1991 && timeTakeniltsiwv<3990){
                //fair
                str_speed_designation="Fair Load Speed ..";

            }else
            if(timeTakeniltsiwv>3991){
                //poor
                str_speed_designation="Poor Load Speed ..";
            }

        //Percentages
            int_percent_score_general=(float)(int_score_general/12)*100;
            int_percent_score_content=(float)(int_score_content/6)*100;
            int_percent_score_structure=(float)(int_score_structure/12)*100;
            //speed percentage
            if(timeTakeniltsiwv>0 && timeTakeniltsiwv<500){
                //perfect1
                final_speed_score_percentage=92;
            }            if(timeTakeniltsiwv>500 && timeTakeniltsiwv<1000){
                //perfect2
                final_speed_score_percentage=83;
            }            if(timeTakeniltsiwv>1000 && timeTakeniltsiwv<1500){
                //perfect3
                final_speed_score_percentage=74;
            }            if(timeTakeniltsiwv>1500 && timeTakeniltsiwv<2000){
                //perfect4
                final_speed_score_percentage=65;
            }            if(timeTakeniltsiwv>2000 && timeTakeniltsiwv<2500){
                //perfect5
                final_speed_score_percentage=56;
            }            if(timeTakeniltsiwv>2500 && timeTakeniltsiwv<3000){
                //perfect6
                final_speed_score_percentage=47;
            }            if(timeTakeniltsiwv>3000 && timeTakeniltsiwv<3500){
                //perfect7
                final_speed_score_percentage=38;
            }            if(timeTakeniltsiwv>3500 && timeTakeniltsiwv<4000){
                //perfect8
                final_speed_score_percentage=29;
            }            if(timeTakeniltsiwv>4000 && timeTakeniltsiwv<4500){
                //perfect9
                final_speed_score_percentage=11;
            }            if(timeTakeniltsiwv>4500){
                //perfect10
                final_speed_score_percentage=6;
            }


            return null;
        }
        protected void onPostExecute (Void result) {
            SLSprogressDialog.hide();
            CLabove0.setVisibility(View.VISIBLE);
            CLabove1.setVisibility(View.GONE);
            CLabove2.setVisibility(View.GONE);
            CLabove3.setVisibility(View.GONE);
            CLabove4.setVisibility(View.GONE);
            CLabove5.setVisibility(View.GONE);
            CLabove6.setVisibility(View.GONE);
            CLabove7.setVisibility(View.GONE);
            HIGHabove0.setVisibility(View.GONE);
            HIGHabove1.setVisibility(View.VISIBLE);
            HIGHabove2.setVisibility(View.VISIBLE);
            HIGHabove3.setVisibility(View.VISIBLE);
            HIGHabove4.setVisibility(View.VISIBLE);
            HIGHabove5.setVisibility(View.VISIBLE);
            HIGHabove6.setVisibility(View.VISIBLE);
            HIGHabove7.setVisibility(View.VISIBLE);

            String str_remarks_general, str_remarks_content, str_remarks_speed, str_remarks_structure;
            str_remarks_general="("+int_score_general+" out of 12 Passed)";
            str_remarks_content="("+int_score_content+" out of 6 Passed)";
            str_remarks_speed=str_speed_designation;
            str_remarks_structure="("+int_score_structure+" out of 12 Passed)";


//GENERAL
            //tv_remarks_GENERAL
            tv_remarks_GENERAL.setText(str_remarks_general);
            //TV_general:percentage
            TV_general.setText(String.valueOf(int_percent_score_general)+"%");
            //PB_general
            PB_general.setProgress((int) int_percent_score_general);
//Content
            tv_remarks_CONTENT.setText(str_remarks_content);
            //TV_general:percentage
            TV_content.setText(String.valueOf(int_percent_score_content)+"%");
            //PB_content
            PB_content.setProgress((int) int_percent_score_content);
//SPEED
            tv_remarks_SPEED.setText(string_final_spee_score_remarks);
            TV_speed.setText(String.valueOf(final_speed_score_percentage)+"%");
            PB_speed.setProgress((int) final_speed_score_percentage);
//STRUCTURE
            tv_remarks_STRUCTURE.setText(str_remarks_structure);
            TV_structure.setText(String.valueOf(int_percent_score_structure)+"%");
            PB_structure.setProgress((int) int_percent_score_structure);


        }
    }

    private class HTML_asyncCLASS extends AsyncTask<Void, Void, Void>{
        private ProgressDialog PprogressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            PprogressDialog = new ProgressDialog(MainActivity.this);
            PprogressDialog.setMessage("Fetching HTML Code...");
            PprogressDialog.setIndeterminate(true);
            PprogressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
//            html_string_async=html_string;

            try {
                bool_ovv1urlreport=true;
                html_string_async = Jsoup.connect(surl).get().html();
                if(html_string_async==""){
                    url_valid_on_bool=false;
                }
            } catch (IOException e) {
                html_string_async="Sakthu";
            }
            return null;
        }
        protected void onPostExecute (Void result) {
            PprogressDialog.hide();
            tvHTML_opseo.setText(html_string_async);
            if(count[0] ==0){
                Toast.makeText(getApplicationContext(), ".. LOADING HTML STRING ..\nPlease wait. This may take some time.", Toast.LENGTH_SHORT).show();
                count[0] = count[0] +1;
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.GONE);
                CLabove2.setVisibility(View.GONE);
                CLabove3.setVisibility(View.VISIBLE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.GONE);
                CLabove6.setVisibility(View.GONE);
                CLabove7.setVisibility(View.GONE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.VISIBLE);
                HIGHabove2.setVisibility(View.VISIBLE);
                HIGHabove3.setVisibility(View.GONE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.VISIBLE);
                HIGHabove6.setVisibility(View.VISIBLE);
                HIGHabove7.setVisibility(View.VISIBLE);
            }else{
                CLabove0.setVisibility(View.GONE);
                CLabove1.setVisibility(View.GONE);
                CLabove2.setVisibility(View.GONE);
                CLabove3.setVisibility(View.VISIBLE);
                CLabove4.setVisibility(View.GONE);
                CLabove5.setVisibility(View.GONE);
                CLabove6.setVisibility(View.GONE);
                CLabove7.setVisibility(View.GONE);
                HIGHabove0.setVisibility(View.VISIBLE);
                HIGHabove1.setVisibility(View.VISIBLE);
                HIGHabove2.setVisibility(View.VISIBLE);
                HIGHabove3.setVisibility(View.GONE);
                HIGHabove4.setVisibility(View.VISIBLE);
                HIGHabove5.setVisibility(View.VISIBLE);
                HIGHabove6.setVisibility(View.VISIBLE);
                HIGHabove7.setVisibility(View.VISIBLE);
            }

        }

    }

    private class DA_domainAuthority_asyncCLASS extends AsyncTask<Void, Void, Void>{
        private ProgressDialog DAprogressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DAprogressDialog = new ProgressDialog(MainActivity.this);
            DAprogressDialog.setMessage("Loading. Please Wait ..");
            DAprogressDialog.setIndeterminate(true);
            DAprogressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {


             return null;
        }
        protected void onPostExecute (Void result) {

            DAprogressDialog.hide();



                    CLabove0.setVisibility(View.GONE);
                    CLabove1.setVisibility(View.GONE);
                    CLabove2.setVisibility(View.GONE);
                    CLabove3.setVisibility(View.GONE);
                    CLabove4.setVisibility(View.VISIBLE);
                    CLabove5.setVisibility(View.GONE);
                    CLabove6.setVisibility(View.GONE);
                    CLabove7.setVisibility(View.GONE);
                    HIGHabove0.setVisibility(View.VISIBLE);
                    HIGHabove1.setVisibility(View.VISIBLE);
                    HIGHabove2.setVisibility(View.VISIBLE);
                    HIGHabove3.setVisibility(View.VISIBLE);
                    HIGHabove4.setVisibility(View.GONE);
                    HIGHabove5.setVisibility(View.VISIBLE);
                    HIGHabove6.setVisibility(View.VISIBLE);
                    HIGHabove7.setVisibility(View.VISIBLE);
                }

        }





}


/*
    //Meta Tags IV-TV
    private class MT_metaTags_asyncCLASS extends AsyncTask<Void, Void, Void>{
        private ProgressDialog MTprogressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MTprogressDialog = new ProgressDialog(MainActivity.this);
            MTprogressDialog.setMessage("Loading...");
            MTprogressDialog.setIndeterminate(true);
            MTprogressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {

        }
        protected void onPostExecute (Void result) {
            MTprogressDialog.hide();

        }

    }
    //Keywords IV-TV
    private class K_keywords_asyncCLASS extends AsyncTask<Void, Void, Void>{
        private ProgressDialog KprogressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            KprogressDialog = new ProgressDialog(MainActivity.this);
            KprogressDialog.setMessage("Loading...");
            KprogressDialog.setIndeterminate(true);
            KprogressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {

        }
        protected void onPostExecute (Void result) {
            KprogressDialog.hide();

        }

    }

*/



