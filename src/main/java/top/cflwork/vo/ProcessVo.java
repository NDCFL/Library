package top.cflwork.vo;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class ProcessVo {
    private String id;
    private String name;
    private String deploymentId;

    public ProcessVo(Deployment processDefinition) {
        this.setId(processDefinition.getId());
        this.name = processDefinition.getName();
    }

    public ProcessVo(ProcessDefinition processDefinition) {
        this.setId(processDefinition.getId());
        this.name = processDefinition.getName();
        this.deploymentId = processDefinition.getDeploymentId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }
}
