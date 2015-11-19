jQuery.namespace("JIRA.Admin.Team.TeamRow");

JIRA.Admin.Team.TeamRow = AJS.RestfulTable.Row.extend({
    initialize: function () {
        AJS.RestfulTable.Row.prototype.initialize.apply(this, arguments);
        this.events["click .project-config-team-delete"] = "_delete";
        this.delegateEvents();
    },
    _delete: function (e) {
        if (!confirm('Delete the team?'))
            return;
        var row = this;
        this.model.destroy({
            data: this.model.toJSON(), success: function () {
                row.remove();
            }
        });
        e.preventDefault();
    },

    render: function () {
        var data = this.model.toJSON(),
            id = this.model.get("id"),
            $el = this.$el;
        $el.attr("id", "team-" + id + "-row").attr("data-id", id);
        $el.html(JIRA.Templates.Team.teamRow({
            team: data
        }));
        return this;
    }
});

jQuery.namespace("JIRA.Admin.Team.EditTeamRow");

JIRA.Admin.Team.EditTeamRow = AJS.RestfulTable.EditRow.extend({
    submit: function () {
        var input = document.getElementById('project-config-team-name-input');
        var input2 = document.getElementById('demo-range-always');

        AJS.$.ajax({
            url: contextPath + '/rest/teams/1.0/teams.json',
            type: 'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({
                name: input.value,
                created: input2.value
            }),
            dataType: 'json'
        }).done(function (data) {
            JIRA.Admin.TeamTable.addRow(data);
            input.value = '';
        });
    },
    render: function () {
        var data = this.model.toJSON(),
            $el = this.$el;
        $el.html(JIRA.Templates.Team.editTeamRow({
            team: data
        }));
        return this;
    }
});