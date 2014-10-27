var theme = function(){
    var theme2 = {
        background : "#EEFAFD",
        header : "#215968",
        container : "#FFFFFF",
        left_side_bar_background : "#AAAAAA",
        footer : "#F5F5F5",
        box_curve_legend_background : "#9BCEDD",
        box_curve_legend_font_color : "#FFFFFF"
    }
    var theme3 = {
        background : "#FFFFFF",
        header : "#215968",
        container : "#FFFFFF",
        left_side_bar_background : "#9BCEDD",
        footer : "#F5F5F5",
        box_curve_legend_background : "#9BCEDD",
        box_curve_legend_font_color : "#FFFFFF"
    }
    var shit = {
        background : "#000000",
        header : "#FFFFFF",
        container : "#FFFFFF",
        left_side_bar_background : "#000000",
        footer : "#F5F5F5",
        box_curve_legend_background : "#9BCEDD",
        box_curve_legend_font_color : "#FFFFFF"
    }
    
    
    
    return{
        applyTheme : function(theme_name){
            if(theme_name ==="shit"){
                theme = shit;
            }
            if(theme_name ==="theme2"){
                theme = theme2;
            }
            if(theme_name ==="theme3"){
                theme = theme3;
            }
            $("body").css({
                "background" : theme.background
            });
            $("#header-v2").css({
                "background" : theme.header
            });
            $("#container").css({
                "background" : theme.container
            });
            $("#left-side-bar-navigation").css({
                "background" : theme.left_side_bar_background
            });
            $("#footer").css({
                "background" : theme.footer
            });
            $(".box-curve legend").css({
                "background" : theme.box_curve_legend_background
            });
            $(".box-curve legend").css({
                "color" : theme.box_curve_legend_font_color
            });
        }
    }
}()