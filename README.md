## Micronaut 3.8.7 Documentation

- [User Guide](https://docs.micronaut.io/3.8.7/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.7/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.7/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## interactions
- a person can make a recommendation to another user's existing lists 
  
- categories can change classification. this will affect all recommendations with the category
  - category can be classified under an existing classification
  - category can be classified under new classification
    - endpoint that takes in category and new classification information
    - same endpoint can be leveraged for classification by name

## stretch interactions
- a user can make a recommendation to another user, but the list doesnt exist.
  - that user should be able to create a recommendation with a "suggested category"
  - ?????? ok so is there a 1:1 between category and list then? guess so? ALONG WITH USER

## models
- a user has a list of recommendations
- a recommendation will have
  - someone who made the recommendation, who is another user
  - a category, think "movies", "books", "music"
  - an action item
  - rating 
- categories can be classified, for example, the above examples of categories can be classified as "media"
  - a user can only have one category and one classsification with a name 
