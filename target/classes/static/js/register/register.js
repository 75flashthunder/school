function goRegister(){
    var user={
        name:$("input[name='name']").val(),
        password:$("input[name='password']").val(),
        email:$("input[name='email']").val(),
        phone:$("input[name='phone']").val(),
        school:$("input[name='school']").val(),
        department:$("input[name='department']").val(),
        major:$("input[name='major']").val(),
        local:$("input[name='local']").val(),
        gender:$("input[name='gender']").val(),
        graduateDate:$("input[name='graduateDate']").val(),
        companyName:$("input[name='companyName']").val(),
        qq:$("input[name='qq']").val()
    }
    $.ajax({
        data:JSON.stringify(user),
        url:"/user/register",
        async:true,
        contentType:"application/json;charset=utf-8",
        type:"post",
        success:function(data){
            console.log("注册完毕");
        },
        error:function(err){
            console.log("注册失败");
        },
    });
}

var availableTags = [
    "ActionScript",
    "AppleScript",
    "Asp",
    "BASIC",
    "C",
    "C++",
    "Clojure",
    "COBOL",
    "ColdFusion",
    "Erlang",
    "Fortran",
    "Groovy",
    "Haskell",
    "Java",
    "JavaScript",
    "Lisp",
    "Perl",
    "PHP",
    "Python",
    "Ruby",
    "Scala",
    "Scheme"
];

$( "#major" ).autocomplete({
    source: availableTags
});