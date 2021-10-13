package com.magicarbon.example.javagit;

import java.nio.file.Paths;
import java.nio.file.Path;

import com.github.git24j.core.Init;
import com.github.git24j.core.Libgit2;
import com.github.git24j.core.Repository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Setup
        Path distTarget = Paths.get("dist/git24j/target");
        Init.loadLibraries(distTarget.resolve("git2"), distTarget.resolve("git24j"));
        Libgit2.init();

        Path repoDir = Paths.get(System.getProperty("user.dir"));
        try (Repository repo = Repository.open(repoDir)){
            System.out.println(repo.workdir());
        }
        // Optional: Shutdown and clean up libgit2 global states.
        Libgit2.shutdown();
        
        System.out.println( "Hello World!" );
    }
}
