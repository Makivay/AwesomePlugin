    var resourcePath = AJS.contextPath() + "/rest/awesomeplugin/latest/oat";
    var elements = "";
    jQuery().get(resourcePath, function(resp){
        elements = resp;
    });

    var restfulTable = new AJS.RestfulTable({
        autoFocus: true,
        el: elements,
        editable: true,
        allowReorder: true,
        resources: {
            all: resourcePath,
            self: resourcePath
        },
        columns: [
            {
                id: "string",
                header: "String"
            },
            {
                id: "date",
                header: "Date"
            },
            {
                id: "action",
                header: "Action"
            }
        ]
    });