Testing & QA Tech Eval
Goal
Design, build, and run a set of tests against a website.
Timeframe
5 days
Background
Canary is branching out! Sure, the honeypots are doing really well, but blogging is where the real juice is at. Medium is getting lots of love, and we want some of that. Being true believers in working smarter not harder, we don’t want to start from scratch, and so we’ve shamelessly stolen a Medium clone to build on.

However, catastrophe! This blogging software has no UI tests!

Your job is to fix that. First, you’ll need to get used to the site. We’ve thrown up a site just for you at:
	http://13.245.237.41:8080/

This is the front-end, written in Vue.js. You can create a user, browse around, create articles and so on.

If you look in the Network tab of your browser’s Developer Tools as you move around the site, you’ll see your browser talking to http://13.245.237.41:5000/api/*, which is the back-end. 
The frontend makes calls to the various API endpoints on that different port.

Specifications:
1. First step is to decide on the automation strategy. Browse the site to get a feel for what’s possible. Document any manual tests you run at this time, with their results.
2. Create a testing environment with your testing framework of choice (could be Selenium WebDriver, Cypress, or whatever you choose). Document the steps as you would for your team in a file called setup.txt.
3. With your testing framework, write a functional test to create a new article on the site. The test should pass.
4. Now try to discover a way to break the New Article functionality (i.e. so the server generates an error). Write a new test function in the same test file, which examines the broken behaviour. The test should fail.
5. Browse the site and find an action which doesn’t seem right, separate from the New Article break (i.e. find a broken part of the site. “Broken” here means the site reacts in an unexpected way, e.g. not providing a useful error message on failure, or simply not fulfilling some action that was expected.) In the same test script from above, add a test for that broken behaviour. Your new test should fail.
6. From the Network tab in the browser, pick an API call (something sent to port 5000), and write a simple test. This test must not use a browser automation framework, instead it should use the language’s native HTTP library (e.g. if written in Python, the test should only use the requests module.) This test should pass.
7. Document how to run the tests.

Bonus: support running the browser automation tests across multiple browsers.

In all the tests you write, be prepared to discuss which assertions you checked and why they were picked.

Submission
As soon as you’re done, send your setup.txt and your other test scripts and outputs
