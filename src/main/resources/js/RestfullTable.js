function getLink(){
    return AJS.RestfulTable.CustomReadView.extend({
        render:function(self){
            if (self !== undefined){
                this.el.innerHTML = "<input class=\"aui-date-picker\" id=\"demo-range-always\" type=\"date\" value =\"" + self.value + "\" />";
                }
            return this.el;
        }
    })
}

function getDate(){
    return AJS.RestfulTable.CustomReadView.extend({
        render:function(self){
            if (self !== undefined){
                this.el.innerHTML = "<input class=\"aui-date-picker\" id=\"demo-range-always\" type=\"date\" value =\"" + self.value + "\" />";
                }
            return this.el;
        }
    })
}

function addTable(target){
    new AJS.RestfulTable({
        allowCreate: true,
        allowEdit: true,
        allowReorder: false,
        allowDelete: true,
        reverseOrder: true,
        el: target,
        resources: {
            all: AJS.contextPath()+"/rest/awesomeplugin/latest/oat/getAll",
            self: AJS.contextPath()+"/rest/awesomeplugin/latest/oat/"
        },
        columns: [
            {
                id: "string",
                header: "String"
            },
            {
                id: "date",
                header: "Date",
            },
            {
                id: "action",
                header: "Action"
            }
        ]
    });
}


jQuery(document).ready(function(){
    var target = jQuery('.restful');
    addTable(target);
});
