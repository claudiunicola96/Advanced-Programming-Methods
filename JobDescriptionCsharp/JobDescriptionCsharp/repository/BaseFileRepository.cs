using JobDescriptionCsharp.domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using JobDescriptionCsharp.validator;
using System.IO;

namespace JobDescriptionCsharp.repository
{
    public class BaseFileRepository<GenericType> : BaseRepository<GenericType>, IFileRepository<GenericType>
        where GenericType : Entity
    {
        protected IFileRepository<GenericType> repository;
        public string fileName { get; set; }

        public BaseFileRepository(IFileRepository<GenericType> repository) : base(repository.getValidator())
        {
            this.repository = repository;
            this.fileName = repository.getFileName();
            loadData();
        }

        public void loadData()
        {
            //@todo: change the search the path of file name
            using (StreamReader reader = new StreamReader(fileName))
            {
                string line;
                while ((line = reader.ReadLine()) != null)
                {
                    GenericType entity = createFromLine(line);
                    this.add(entity);
                }
            }
        }

        public virtual GenericType createFromLine(string line)
        {
            return repository.createFromLine(line);
        }

        public void writeData()
        {
            using (StreamWriter writer = new StreamWriter(@"E:\\Facultate\anul2\\MAP\\JobDescriptionCsharp\\JobDescriptionCsharp\\data\\s.txt"))
            {
                writer.WriteLine(transform(repository.getEntityById(1)));

                //repository.getAll().ForEach(delegate (GenericType item)
                //{
                //    writer.WriteLine(transform(item));
                //});
            }
        }

        public virtual string transform(GenericType item)
        {
            return repository.transform(item);
        }

        public IValidator<GenericType> getValidator()
        {
            return this.validator;
        }

        public string getFileName()
        {
            return this.fileName;
        }
    }
}
