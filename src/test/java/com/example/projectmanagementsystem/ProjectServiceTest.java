package com.example.projectmanagementsystem;

import com.example.projectmanagementsystem.Repository.ProjectRepository;
import com.example.projectmanagementsystem.Service.ProjectService;
import com.example.projectmanagementsystem.models.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, "Project 1", "Description 1", new Date(), new Date()));
        projects.add(new Project(2L, "Project 2", "Description 2", new Date(), new Date()));

        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> result = projectService.getAllProjects();
        assertEquals(2, result.size());
    }

    @Test
    void testGetProjectById() {
        Project project = new Project(1L, "Project 1", "Description 1", new Date(), new Date());

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Optional<Project> result = projectService.getProjectById(1L);
        assertEquals(project, result.orElse(null));
    }
    @Test
    void testSaveProject() {
        Project project = new Project(1L, "Project 1", "Description 1", new Date(), new Date());

        when(projectRepository.save(project)).thenReturn(project);

        Project savedProject = projectService.saveProject(project);
        assertEquals(project, savedProject);
    }

    @Test
    void testDeleteProject() {
        Long projectId = 1L;

        doNothing().when(projectRepository).deleteById(projectId);

        projectService.deleteProject(projectId);

        verify(projectRepository, times(1)).deleteById(projectId);
    }

}
