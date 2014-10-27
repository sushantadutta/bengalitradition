/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    //        $("#program-hide").hide();
    //        $(".content-title-toolbar").click(function(){
    //            $("#program-hide").slideToggle("slow");
    //        });
        
    $("#audit-hide").hide();
    $("#audit-collapse").click(function(){
        $("#audit-hide").slideToggle("slow");
        $("#audit-collapse").hide();
        $("#audit-expand").show();
    });
    $("#audit-expand").click(function(){
        $("#audit-hide").slideToggle("slow");
        $("#audit-expand").hide();
        $("#audit-collapse").show();
    });
});
