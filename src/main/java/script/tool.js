var magic = magic || {};

var base = "E:\\javaweb/magic\\app\\test\\pigasuo\\src\\main\\java\\script\\";
load(base+ "load.js")
var projectId = 123456;



var testObjRuel = {
    ruleName : "first001"
    ,

    watch : {
        "m1":"all"
    }
    , when :function(context,facObject) {

    }
    ,then :function (context,facObject) {

    }
}

var Rule =  Java.type("com.pig.Rule");

function registerRule (rmyRule) {
   
    var ruleITem = new Rule();
    ruleITem.setName(rmyRule.ruleName);
    ruleITem.setCode(rmyRule.when.toString());
    print(ruleITem);
}

print("----------------tools00000000000");
registerRule(testObjRuel);
print("----------------tools00000000000")




