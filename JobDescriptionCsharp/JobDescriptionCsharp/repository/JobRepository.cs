using JobDescriptionCsharp.domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using JobDescriptionCsharp.validator;

namespace JobDescriptionCsharp.repository
{
    public class JobRepository : BaseFileRepository<Job>
    {
        public static object job { get; private set; }

        public JobRepository(IValidator<Job> validator, string fileName) : base(this)
        {
            this.validator = validator;
            this.fileName = fileName;
        }

        public override Job createFromLine(string line)
        {
            string[] tokens = line.Split('|');
            return new Job(Int32.Parse(tokens[0]), tokens[1], tokens[2]);
        }

        public override string transform(Job item)
        {
            return item.id + '|' + item.name + '|' + item.type;
        }

        public string getFileName()
        {
            return this.fileName;
        }
    }
}
