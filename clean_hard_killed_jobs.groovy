import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.job.WorkflowRun
import org.jenkinsci.plugins.workflow.support.steps.StageStepExecution

// This script should be used when your jenkins build keep waiting on
// previously hard killed build 

jobByFullName = 'folder/branch'
// This job number should be the one all teh jobs keep waiting on
jobBuildNumber = 'jobnumber'

//kill it
Jenkins j = Jenkins.instance
WorkflowRun b = j.getItemByFullName(jobByFullName).getBuild(jobBuildNumber)
b.doKill()
StageStepExecution.exit(b)
