package ru.stqa.pft.github.tests.tests;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;



public class GithubTests {


  @Test
  public void testRepo() throws IOException {
    Github github = new RtGithub("7fd767de8fa6723cd78fbeb6ab64c338b7fdfc3a");
    Branches branches = github.repos().get(new Coordinates.Simple("IrinaZibby", "GitHubTests")).branches();
    System.out.println(branches.repo());
  }

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("7fd767de8fa6723cd78fbeb6ab64c338b7fdfc3a");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("IrinaZibby", "GitHubTests")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}

