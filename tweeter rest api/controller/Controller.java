package com.company.rest.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class Controller {
    private static final List<Tweet> tweets = new ArrayList<>();
    private static final Map<String, User> userProfile = new HashMap<>();

    private boolean containsInvalidChars(String name) {
        System.out.println(name);
        return ((name != null) && (!name.equals(""))
                && (name.matches("^[a-zA-Z]*$")));
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> requestBodyMap) {
        String email = requestBodyMap.get("email");
        String name = requestBodyMap.get("name");
        String password = requestBodyMap.get("password");
        if (!userProfile.containsKey(email)) {
            System.out.println("email - " + email + " name- " + name);
            System.out.println(isValidEmail(email) + " " + containsInvalidChars(name));
            if (isValidEmail(email) && containsInvalidChars(name) && password.length() > 3) {
                userProfile.put(email, new User(name, Math.abs(email.hashCode()), password));
                return new ResponseEntity<>("User add successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid Input", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User already exist", HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/tweets")
    public ResponseEntity<?> getTweets(@RequestParam String email, @RequestParam String password) {
        if (userProfile.containsKey(email) && userProfile.get(email).getPassword().equals(password)) {

            return new ResponseEntity<List<Tweet>>(tweets.stream()
                    .filter(tweet -> tweet.getUserId() == Math.abs(email.hashCode())).collect(Collectors.toList())
                    , HttpStatus.OK);
        }

        return new ResponseEntity<String>("user not match", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/update")
    private ResponseEntity<String> updateRecord(@RequestBody Map<String, String> requestBodyMap) {
        String email = requestBodyMap.get("email");
        String name = requestBodyMap.get("name");
        String password = requestBodyMap.get("password");
        if (!containsInvalidChars(name)) {
            return new ResponseEntity<>("name contains invalid characters",
                    HttpStatus.BAD_REQUEST);
        } else if (userProfile.containsKey(email) && userProfile.get(email).getPassword().equals(password)) {
            User user = userProfile.get(email);
            String currName = user.getName();
            if (currName.equals(name)) {
                return new ResponseEntity<>("No change rquired",
                        HttpStatus.OK);
            } else {
                user.setName(name);
                userProfile.put(email, user);
                return new ResponseEntity<>("update successful",
                        HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User doesn't exist",
                HttpStatus.NOT_FOUND);

    }

    @PostMapping("/tweet")
    public ResponseEntity<String> postTweet(@RequestBody Map<String, String> tweetBody) {
        if (userProfile.containsKey(tweetBody.get("email"))
                && userProfile.get(tweetBody.get("email")).getPassword().equals(tweetBody.get("password"))) {
            if (tweetBody.containsKey("tweet")) {
                Integer userId = userProfile.get(tweetBody.get("email")).getUserid();
                tweets.add(new Tweet(tweetBody.get("tweet"), userId, Timestamp.from(Instant.now())));
                return new ResponseEntity<String>("Your tweet is successfuly posted", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Tweet is not Found in your request", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("UserId Or Password  is not matched", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/follow")
    public ResponseEntity<String> follow(@RequestBody Map<String, String> requestBodyMap) {
        if (requestBodyMap.containsKey("userEmail") && requestBodyMap.containsKey("followerEmail")) {
            String userEmail = requestBodyMap.get("userEmail");
            String password = requestBodyMap.get("password");
            String followerEmail = requestBodyMap.get("followerEmail");
            if (userEmail != followerEmail && userProfile.containsKey(userEmail)
                    && userProfile.containsKey(followerEmail) && userProfile.get(userEmail).getPassword().equals(password)) {
                userProfile.get(userEmail).getFollowers().add(new Follower(userProfile.get(followerEmail).getUserid()));
                System.out.println(userProfile.get(userEmail).getFollowers());
                return new ResponseEntity<String>("Follower add successfully", HttpStatus.OK);
            }
            return new ResponseEntity<String>("User not found in Data", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Invalid input", HttpStatus.BAD_REQUEST);
    }


    //    User can delete account  -->DELETE
    @DeleteMapping("/delete")
    String deleteRecord(@RequestParam String email) {
        userProfile.remove(email);
        return email + " successfully deleted";
    }

}

