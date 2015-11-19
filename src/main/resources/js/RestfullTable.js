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

jQuery(document).ready(function(){
    var rt = new AJS.RestfulTable({
        allowCreate: true,
        allowEdit: false,
        allowReorder: false,
        allowDelete: false,
        reverseOrder: true,
        el: jQuery('.restful'),
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
                readView: getLink()
            },
            {
                id: "action",
                header: "Action"
            }
        ]
    });
})
