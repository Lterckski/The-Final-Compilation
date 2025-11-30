 The-# The-Final-Compilation
A text-based RPG built in Java for our course project. Players explore three distinct worlds, battle enemies, interact with NPCs, and uncover a twist-filled story as they collect the Three Stones to return home. Inspired by classic RPGs and fantasy themes, designed for console play.

# How to Collaborate on GitHub (For Absolute Beginners)

Welcome to our collaborative project! This guide will walk you through the essential steps for working together using GitHub, even if you have zero experience.

---
## 1. **Set Up Git and GitHub**

1. **Create a GitHub account** at https://github.com/.
2. **Install Git** on your computer:
   - Download: https://git-scm.com/downloads
   - Follow the install instructions for your operating system.

3. **Configure Git** (run these in your terminal or command prompt):
   ```
   git config --global user.name "Your Name"
   git config --global user.email "your@email.com"
   ```

---

## 2. **Clone the Repository**

This copies the project to your computer.

1. Go to: https://github.com/Lterckski/The-Final-Compilation
2. Click the green **Code** button, then copy the URL.
3. In your terminal, run:
   ```
   git clone https://github.com/Lterckski/The-Final-Compilation.git
   ```
4. Change into the project folder:
   ```
   cd The-Final-Compilation
   ```

---

## 3. **Create a New Branch**

Branches let you work on your own copy without disturbing the main project.

1. To create a new branch (replace `your-branch-name` with something descriptive, e.g., `add-battle-system`):
   ```
   git checkout -b your-branch-name
   ```
2. Now, you’re working on your branch! You can make changes freely.

---

## 4. **Make Changes and Commit**

1. Open project files in your code editor and make your changes.
2. Save your files.
3. Check what changed:
   ```
   git status
   ```
4. Stage your changes (prepare them for commit):
   ```
   git add .
   ```
   (The `.` means “add everything that changed.”)
5. Commit your changes with a message:
   ```
   git commit -m "Describe what you changed"
   ```

---

## 5. **Push Your Changes to GitHub**

1. Push your branch and changes to GitHub:
   ```
   git push origin your-branch-name
   ```

---

## 6. **Open a Pull Request (PR)**

This lets the team review and merge your work into the main project.

1. Go to the repository on GitHub.
2. You’ll see a banner offering to open a pull request for your branch. Click it, or:
   - Click **Pull requests**
   - Click **New pull request**
   - Select your branch as the compare branch.
3. Add a clear title and description, then click **Create pull request**.

---

## 7. **Review and Merge Pull Requests**

- Team members can comment, request changes, or approve.
- Once approved, click **Merge pull request**.

---

## 8. **Keep Your Local Project Up to Date**

1. Switch to the main branch:
   ```
   git checkout main
   ```
2. Pull the latest changes:
   ```
   git pull origin main
   ```
3. If you want to update your branch with the latest main changes:
   ```
   git checkout your-branch-name
   git merge main
   ```
   - If you see a conflict, ask for help or search online for "git resolve conflict".

---

## 9. **General Workflow Tips**

- Always create a new branch for each new feature or fix.
- Pull the latest changes from `main` before starting new work.
- Commit often with clear messages.
- Never code directly on the `main` branch.
- Ask for help if you get stuck!

---

## 10. **Common Commands Cheat Sheet**

| Action                        | Command                                    |
|-------------------------------|--------------------------------------------|
| Check current branch          | `git branch`                               |
| List all branches             | `git branch -a`                            |
| Switch to a branch            | `git checkout branch-name`                 |
| Create a new branch           | `git checkout -b branch-name`              |
| See what’s changed            | `git status`                               |
| Add changes                   | `git add .`                                |
| Commit with a message         | `git commit -m "your message"`             |
| Push branch to GitHub         | `git push origin branch-name`              |
| Pull latest from main         | `git pull origin main`                     |
| Merge main into your branch   | `git merge main`                           |

---

If you have ANY questions, don’t hesitate to ask the team or search for tutorials on YouTube. We’re all learning together!