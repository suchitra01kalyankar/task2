package com.example.TaskManagement.Service;


import com.example.TaskManagement.Entities.Team;
import com.example.TaskManagement.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long teamId, Team teamDetails) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setName(teamDetails.getName());
            team.setDescription(teamDetails.getDescription());
            team.setUsers(teamDetails.getUsers());
            team.setTasks(teamDetails.getTasks());
            return teamRepository.save(team);
        } else {
            throw new RuntimeException("Team not found with ID: " + teamId);
        }
    }

    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with ID: " + teamId));
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void addUserToTeam(Long teamId, Long userId) {
        Team team = getTeamById(teamId);
        // Logic to add user to team (requires User entity and repository)
        System.out.println("User " + userId + " added to Team " + teamId);
    }

    public void removeUserFromTeam(Long teamId, Long userId) {
        Team team = getTeamById(teamId);
        // Logic to remove user from team (requires User entity and repository)
        System.out.println("User " + userId + " removed from Team " + teamId);
    }
}
