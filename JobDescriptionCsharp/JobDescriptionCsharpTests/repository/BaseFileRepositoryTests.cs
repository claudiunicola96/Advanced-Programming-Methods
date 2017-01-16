using JobDescriptionCsharp.domain;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using JobDescriptionCsharp.repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using JobDescriptionCsharp.validator;

namespace JobDescriptionCsharp.repository.Tests
{
    [TestClass()]
    public class BaseFileRepositoryTests
    {
        BaseFileRepository<Job> repository;
        JobValidator validator;

        [TestInitialize()]
        public void initialize()
        {
            validator = new JobValidator();
            string fileName = @"E:\\Facultate\anul2\\MAP\\JobDescriptionCsharp\\JobDescriptionCsharp\\data\\jobs.txt";
            JobRepository jobRepo = new JobRepository(validator, fileName);
            repository = new BaseFileRepository<Job>(jobRepo);
        }

        [TestMethod()]
        public void loadDataTest()
        {
            repository.loadData();
            Assert.AreEqual(6, repository.getAll().Count());
        }

        [TestMethod()]
        public void createFromLineTest()
        {
            Job job = new Job(1, "Programator", "full-time");
            string line = "1|Programator|full-time";
            Job job1 = repository.createFromLine(line);
            Assert.AreEqual(job.id, job1.id);
            Assert.AreEqual(job.name, job1.name);
            Assert.AreEqual(job.type, job1.type);
        }


        [TestMethod()]
        public void getValidatorTest()
        {
            Assert.AreSame(validator, repository.getValidator());
        }

        [TestMethod()]
        public void writeDataTest()
        {
            repository.writeData();
        }

        [TestMethod()]
        public void getEntityById()
        {
            Job job = repository.getEntityById(1);
            Assert.AreEqual(job.id, 1);
            Assert.AreEqual(job.name, "Programator");
        }

    }
}