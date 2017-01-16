using JobDescriptionCsharp.domain;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using JobDescriptionCsharp.repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using JobDescriptionCsharp.validator;

namespace JobDescriptionCsharp.repository.Tests
{
    [TestClass()]
    public class BaseRepositoryTests
    {
        BaseRepository<Task> repo;

        [TestInitialize()]
        public void initialize()
        {
            TaskValidator validator = new TaskValidator();
            repo = new BaseRepository<Task>(validator);

            Task t1 = new Task(1, "desc1");
            Task t2 = new Task(2, "desc2");
            Task t3 = new Task(3, "desc3");
            Task t4 = new Task(4, "desc4");
            repo.add(t1);
            repo.add(t2);
            repo.add(t3);
            repo.add(t4);
        }

        [TestMethod()]
        public void addTest()
        {
            Task t5 = new Task(5, "ddd");
            repo.add(t5);
            Assert.AreEqual(5, repo.getAll().Count);
        }

        [TestMethod()]
        public void getAllTest()
        {
            Assert.AreEqual(4, repo.getAll().Count);
        }

        [TestMethod()]
        public void getEntityByIdTest()
        {
            Task task = repo.getEntityById(1);
            Assert.AreEqual("desc1", task.description);
        }

        [TestMethod()]
        public void getLastIdTest()
        {
            int id = repo.getLastId();
            Assert.AreEqual(4, id);
        }

        [TestMethod()]
        public void removeTest()
        {
            Task task = repo.getEntityById(1);
            repo.remove(task);
            Assert.IsNull(repo.getEntityById(1));
        }

        [TestMethod()]
        public void updateTest()
        {
            Task newTask = new Task(2, "updated");
            repo.update(newTask);
            Assert.AreEqual(newTask, repo.getEntityById(2));
        }
    }
}