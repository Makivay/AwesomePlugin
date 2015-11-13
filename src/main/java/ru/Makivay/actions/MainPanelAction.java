package ru.Makivay.actions;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.web.action.JiraWebActionSupport;

/**
 * Created by Kmatveev on 12.11.2015.
 */
public class MainPanelAction extends JiraWebActionSupport {

    @Override
    protected void doValidation() {
        ApplicationUser user = ComponentAccessor.getJiraAuthenticationContext().getUser();
        if (user != null && user.isActive()) {
            super.doValidation();
        } else {
            addErrorMessage("User not asigned.");
        }
    }

    @Override
    protected String doExecute() throws Exception {
        return INPUT;
    }
}
